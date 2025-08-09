#include <iostream>
using namespace std;
// RTTI -> Run Time Type Information
// We use typeid() operator to detect the type of object present
// inside the pointer. But make sure that classes are ploymorphic

class Person
{
    string name;

public:
    virtual void accept()
    {
        cout << "Person::accept()" << endl;
    }
    virtual void display()
    {
        cout << "Person::display()" << endl;
    }

    virtual ~Person() { cout << "Person Destructor\n"; }
};

class Employee : public Person
{
    int id;
    double salary;

public:
    void accept()
    {
        cout << "Employee::accept()" << endl;
    }
    void display()
    {
        cout << "Employee::display()" << endl;
    }
};

class Student : public Person
{
    int rollno;
    double marks;

public:
    void accept()
    {
        cout << "Student::accept()" << endl;
    }
    void display()
    {
        cout << "Student::display()" << endl;
    }
};

int main()
{
    Person *p;
    // p = new Person();
    // p = new Employee(); // upcasting
    p = new Student();                        // upcasting
    Student *st = dynamic_cast<Student *>(p); // Safe downcasting

    if (st) // Check if the cast was successful
    {
        cout << "Type of p = " << typeid(p).name() << endl;
        cout << "Type of *p = " << typeid(*p).name() << endl;
        cout << "Type of *st = " << typeid(*st).name() << endl;
    }
    else
    {
        cout << "Downcasting failed!" << endl;
    }

    delete p; // Only delete `p`, since `st` is just another reference to the same object.
    p = nullptr;

    return 0;
}