#include <iostream>
using namespace std;

class Employee
{
private:
    int empid;
    string name;
    double salary;

public:
    void initEmployee()
    {
        // TO-DO
    }

    void acceptEmployee()
    {
        cout << "Enter the id - ";
        cin >> empid;
        cout << "Enter the name - ";
        cin >> name;
        cout << "Enter the salary - ";
        cin >> salary;
    }

    void displayEmployee()
    {
        cout << "Empid = " << empid << endl;
        cout << "Name = " << name << endl;
        cout << "Salary = " << salary << endl;
    }
};

int menu()
{
    int choice;
    cout << "0. EXIT" << endl;
    cout << "1. Accept the employee" << endl;
    cout << "2. Display the employee" << endl;
    cout << "Enter the choice - ";
    cin >> choice;
    return choice;
}

int main()
{
    int choice;
    Employee e;
    // e.initEmployee();
    while ((choice = menu()) != 0)
    {
        switch (choice)
        {
        case 1:
            e.acceptEmployee();
            break;
        case 2:
            e.displayEmployee();
            break;
        default:
            cout << "Wrong choice...:(" << endl;
            break;
        }
    }
    return 0;
}

int main1()
{
    int choice;
    Employee emp;
    do
    {
        cout << "0. EXIT" << endl;
        cout << "1. Accept the employee" << endl;
        cout << "2. Display the employee" << endl;
        cout << "Enter the choice - ";
        cin >> choice;
        switch (choice)
        {
        case 0:
            cout << "Thank you for using the app...:)" << endl;
            break;
        case 1:
            emp.acceptEmployee();
            break;
        case 2:
            emp.displayEmployee();
            break;
        default:
            cout << "Wrong choice...:(" << endl;
            break;
        }

    } while (choice != 0);
    return 0;
}