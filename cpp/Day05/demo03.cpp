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
        cout << "Id - " << id << endl;
        cout << "Name - " << name << endl;
        cout << "Salary - " << salary << endl;
    }
    int getId()
    {
        return id;
    }
};

int menu()
{
    int choice;
    cout << "*************************" << endl;
    cout << "0. EXIT" << endl;
    cout << "1. Add Employee" << endl;
    cout << "2. Display All Employees" << endl;
    cout << "3. Find Employee" << endl;
    cout << "Enter the choice - ";
    cin >> choice;
    cout << "*************************" << endl;
    return choice;
}

void addDummyRecored(Employee **arr, int &index)
{
    // dummy records for testing...
    arr[index] = new Employee(1, "Anil", 10000);
    index++;
    arr[index] = new Employee(2, "Mukesh", 20000);
    index++;
    arr[index] = new Employee(3, "Ramesh", 30000);
    index++;
    arr[index] = new Employee(4, "Suresh", 40000);
    index++;
}

int findEmployee(Employee **ptr, int index)
{
    int id;
    cout << "Enter the id to search - ";
    cin >> id;
    for (int i = 0; i < index; i++)
    {
        if (id == ptr[i]->getId())
            return i;
    }
    return -1;
}

int main()
{
    // Employee** ptr = new Employee*[5];
    Employee *arr[5];
    int index = 0;
    addDummyRecored(arr, index);

    int choice;
    while ((choice = menu()) != 0)
    {
        switch (choice)
        {
        case 1:
            if (index < 5)
            {
                arr[index] = new Employee();
                arr[index]->accept();
                cout << "Employee Added..." << endl;
                index++;
            }
            else
                cout << "No Vacency..." << endl;
            break;
        case 2:
            for (int i = 0; i < index; i++)
                arr[i]->display();
            break;
        case 3:
        {
            int i = findEmployee(arr, index);
            if (i != -1)
                arr[i]->display();
            else
                cout << "Employee not found..." << endl;
        }
        break;
        default:
            cout << "Wrong choice ..." << endl;
            break;
        }
    }
    return 0;
}
