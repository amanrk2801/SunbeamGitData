#include <iostream>
using namespace std;

// enum
enum Weeks
{
    SUN = 1,
    MON,
    TUE,
    WED,
    THUR,
    FRI,
    SAT
};

enum EMenu
{
    EXIT,
    ADD_EMPLOYEE,
    DISPLAY_EMPLOYEE,
    FIND_EMPLOYEE
};

EMenu menu()
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
    return EMenu(choice);
}

int main()
{
    EMenu choice;
    while ((choice = menu()) != EXIT)
    {
        switch (choice)
        {
        case ADD_EMPLOYEE:
            cout << "Add employee" << endl;
            break;
        case DISPLAY_EMPLOYEE:
            cout << "Display employee" << endl;
            break;
        case FIND_EMPLOYEE:
            cout << "Find employee" << endl;
            break;
        default:
            cout << "Wrong chocie." << endl;
            break;
        }
    }
    return 0;
}