#include <iostream>
using namespace std;
class Employee
{
public:
    Employee()
    {
        cout << "Employee::Ctor()" << endl;
    }

    void acceptEmployee()
    {
        cout << "Employee::accept()" << endl;
    }

    void displayEmployee()
    {
        cout << "Employee::display()" << endl;
    }

    ~Employee()
    {
        cout << "Employee::Dtor()" << endl;
    }
};

class SmartPointer
{
private:
    Employee *ptr;

public:
    SmartPointer(Employee *ptr)
    {
        this->ptr = ptr;
    }

    Employee *getEmployeePtr()
    {
        return ptr;
    }

    Employee *operator->()
    {
        return ptr;
    }

    ~SmartPointer()
    {
        delete ptr;
    }
};

int main()
{
    // Employee *ptr = new Employee();
    SmartPointer sp1(new Employee());
    // sp1.displaySmartPointer();

    // sp1.getEmployeePtr()->acceptEmployee();
    // sp1.getEmployeePtr()->displayEmployee();

    sp1->acceptEmployee(); // sp1.operator->()
    sp1->displayEmployee();

    // SmartPointer sp2(new Employee());
    // SmartPointer sp3(new Employee());
    // SmartPointer sp4(new Employee());
    // SmartPointer sp5(new Employee());
    cout << "main ends here.." << endl;
    return 0;
}

int main2()
{
    Employee *ptr = new Employee();
    ptr->acceptEmployee();
    ptr->displayEmployee();
    cout << "main ends here.." << endl;
    delete ptr;
    ptr = nullptr;
    return 0;
}

int main1()
{
    Employee e1;
    e1.acceptEmployee();
    e1.displayEmployee();
    cout << "main ends here.." << endl;
    return 0;
}