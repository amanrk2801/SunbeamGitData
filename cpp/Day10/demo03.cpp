#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
using namespace std;
class Employee
{
    int id;
    string name;
    double salary;

public:
    Employee()
    {
    }
    Employee(int id, string name, double salary)
    {
        this->id = id;
        this->name = name;
        this->salary = salary;
    }

    void accept()
    {
        cout << "Enter the id - ";
        cin >> id;
        cout << "Enter the name - ";
        cin >> name;
        cout << "Enter the salary - ";
        cin >> salary;
    }

    void display()
    {
        cout << "Id -" << id << endl;
        cout << "Name -" << name << endl;
        cout << "Salary -" << salary << endl;
        cout << "-------------------------" << endl;
    }

    int getId()
    {
        return id;
    }
    string getName()
    {
        return name;
    }
    double getSalary()
    {
        return salary;
    }
    void setSalary(double salary)
    {
        this->salary = salary;
    }
};

int menu()
{
    cout << "***************************" << endl;
    int choice;
    cout << "0. EXIT" << endl;
    cout << "1. Add Employee" << endl;
    cout << "2. Display All Employees" << endl;
    cout << "3. Find Employee" << endl;
    cout << "4. Delete Employee" << endl;
    cout << "5. Update Employee Salary" << endl;
    cout << "Enter your choice - ";
    cin >> choice;
    cout << "***************************" << endl;

    return choice;
}

int findEmployee(vector<Employee *> &employeeList)
{
    int id;
    cout << "Enter the employee id to search - ";
    cin >> id;
    for (int i = 0; i < employeeList.size(); i++)
        if (id == employeeList[i]->getId())
            return i;
    return -1;
}

void loadEmployees(vector<Employee *> &employeeList)
{
    ifstream fin("employee.txt");
    string data;
    while (getline(fin, data))
    {
        string id, name, salary;
        stringstream ss(data);
        getline(ss, id, ',');
        getline(ss, name, ',');
        getline(ss, salary, ',');

        employeeList.push_back(new Employee(stoi(id), name, stod(salary)));
    }
    fin.close();
    cout << "****************************" << endl;
    cout << "Employee loaded in the vector.." << endl;
    cout << "****************************" << endl;
}

void saveEmployees(vector<Employee *> &employeeList)
{
    ofstream fout("employee.txt");
    for (int i = 0; i < employeeList.size(); i++)
    {
        Employee *ptr = employeeList[i];
        fout << ptr->getId() << "," << ptr->getName() << "," << ptr->getSalary() << endl;
    }
    fout.close();
    cout << "****************************" << endl;
    cout << "Employee Saved in the file.." << endl;
    cout << "****************************" << endl;
}

int main()
{
    int choice;
    vector<Employee *> employeeList;
    loadEmployees(employeeList);
    while ((choice = menu()) != 0)
    {
        switch (choice)
        {
        case 1:
        {
            // added the employee in the vector
            Employee *ptr = new Employee();
            ptr->accept();
            employeeList.push_back(ptr);
            cout << "Employee added..." << endl;
        }
        break;
        case 2:
            // display all the employees from the vector
            for (int i = 0; i < employeeList.size(); i++)
                employeeList[i]->display();
            break;
        case 3:
        {
            // call the findEmployee() to get the index of the emp
            // and display it here
            int index = findEmployee(employeeList);
            if (index != -1)
                employeeList[index]->display();
            else
                cout << "Employee not found..." << endl;
        }
        break;
        case 4:
        {
            // find the employee first and get its index
            int index = findEmployee(employeeList);
            if (index != -1)
            {
                // delete the emp obejct from the heap memory
                //  and then erase the block from the vector
                //  which was holding the address of the emp in heap
                delete employeeList[index];
                employeeList.erase(employeeList.begin() + index);
                cout << "Employee deleted..." << endl;
            }
            else
                cout << "Employee not found..." << endl;
        }
        break;
        case 5:
        {
            int index = findEmployee(employeeList);
            if (index != -1)
            {
                double salary;
                cout << "Enter new salary - ";
                cin >> salary;
                employeeList[index]->setSalary(salary);
                cout << "Employee updated..." << endl;
            }
            else
                cout << "Employee not found..." << endl;
        }
        break;
        default:
            cout << "Wrong choice..." << endl;
            break;
        }
    }
    saveEmployees(employeeList);
    return 0;
}