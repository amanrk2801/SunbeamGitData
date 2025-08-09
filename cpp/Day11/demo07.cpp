#include <iostream>
#include <memory>
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

int main()
{
    weak_ptr<Employee> w1;
    {
        cout << "block scope starts here..." << endl;
        shared_ptr<Employee> s1(new Employee);
        w1 = s1;
        cout << "block scope ends here..." << endl;
    }
    cout << "main ends here..." << endl;
    return 0;
}

int main2()
{
    shared_ptr<Employee> s1;
    {
        cout << "block scope starts here..." << endl;
        shared_ptr<Employee> s2(new Employee);
        s1 = s2;
        cout << "block scope ends here..." << endl;
    }
    cout << "main ends here..." << endl;
    return 0;
}

int main1()
{
    unique_ptr<Employee> u1(new Employee);
    u1->acceptEmployee();
    u1->displayEmployee();

    // unique_ptr<Employee> u2 = u1; // NOT OK
    cout << "main ends here..." << endl;
    return 0;
}