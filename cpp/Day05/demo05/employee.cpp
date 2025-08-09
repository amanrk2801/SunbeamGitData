#include "employee.h"

Employee::Employee()
{
    id = 0;
    name = "";
    salary = 0;
}

Employee::Employee(int id, string name, double salary)
{
    this->id = id;
    this->name = name;
    this->salary = salary;
}

void Employee::accept()
{
    cout << "Enter the id - ";
    cin >> id;
    cout << "Enter the name - ";
    cin >> name;
    cout << "Enter the salary - ";
    cin >> salary;
}

void Employee::display()
{
    cout << "Id - " << id << endl;
    cout << "Name - " << name << endl;
    cout << "Salary - " << salary << endl;
}
