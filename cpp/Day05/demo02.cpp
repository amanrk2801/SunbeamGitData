#include <iostream>
using namespace std;

class Employee
{
    int id;
    string name;
    double salary;

public:
    Employee() : Employee(0, "", 0) {}

    Employee(int id, string name, double salary)
    {
        this->id = id;
        this->name = name;
        this->salary = salary;
    }

    void display()
    {
        cout << "Id - " << id << endl;
        cout << "Name - " << name << endl;
        cout << "Salary - " << salary << endl;
    }
};

int main()
{
    Employee ***ptr = new Employee **[2]; // outer array-> Departments
    ptr[0] = new Employee *[3];           // Inner array at index 0 in outer array -> Dev
    ptr[1] = new Employee *[2];           // Inner array at index 1 in outer array-> Test

    // Employees in Development dept
    ptr[0][0] = new Employee(1, "Anil", 50000);
    ptr[0][1] = new Employee(2, "Mukesh", 40000);
    ptr[0][2] = new Employee(3, "Ramesh", 30000);

    // Employees in Testing dept
    ptr[1][0] = new Employee(4, "Suresh", 20000);
    ptr[1][1] = new Employee(5, "Ram", 10000);

    for (int i = 0; i < 2; i++)
    {
        if (i == 0)
        {
            cout << "Employees from Development Department ->" << endl;
            for (int j = 0; j < 3; j++)
                ptr[i][j]->display();
        }
        if (i == 1)
        {
            cout << "Employees from Testing Department ->" << endl;
            for (int j = 0; j < 2; j++)
                ptr[i][j]->display();
        }
    }

    // Deallocation of objects first
    for (int i = 0; i < 2; i++)
    {
        if (i == 0)
            for (int j = 0; j < 3; j++)
            {
                delete ptr[i][j];
                ptr[i][j] = NULL;
            }
        if (i == 1)
            for (int j = 0; j < 2; j++)
            {
                delete ptr[i][j];
                ptr[i][j] = NULL;
            }
    }

    // deallocate the inner arrays
    for (int i = 0; i < 2; i++)
    {
        delete[] ptr[i];
        ptr[i] = NULL;
    }

    // deallocating the outer array
    delete[] ptr;
    ptr = NULL;
    return 0;
}

int main1()
{
    // TO-DO
    Employee arr[2][3];
    return 0;
}