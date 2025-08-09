#include <iostream>
using namespace std;
class Person
{
private:
    string name;

public:
    Person()
    {
        cout << "Person()" << endl;
    }
    Person(string name)
    {
        cout << "Person(string)" << endl;
        this->name = name;
    }

    virtual void accept()
    {
        cout << "Enter name - ";
        cin >> name;
    }
    virtual void display()
    {
        cout << "Name - " << name << endl;
    }
};

class Employee : public Person
{
private:
    int id;
    double salary;

public:
    Employee()
    {
        cout << "Empoyee()" << endl;
    }

    Employee(int id, string name, double salary) : Person(name)
    {
        cout << "Empoyee(int,string,double)" << endl;
        this->id = id;
        this->salary = salary;
    }

    // function overriding
    void accept() override
    {
        cout << "Enter the id - ";
        cin >> id;

        Person::accept();
        // reusing the base class function by unhiding its implementation

        cout << "Enter the salary - ";
        cin >> salary;
    }

    void display() override
    {
        cout << "Id - " << id << endl;
        Person::display();
        cout << "Salary - " << salary << endl;
    }
};

class Student : public Person
{
private:
    int rollno;
    double marks;

public:
    Student()
    {
        cout << "Studnet()" << endl;
    }

    Student(int rollno, string name, double marks) : Person(name)
    {
        cout << "Student(int,string,double)" << endl;
        this->rollno = rollno;
        this->marks = marks;
    }

    void accept()
    {
        cout << "Enter the rollno - ";
        cin >> rollno;
        Person::accept();
        cout << "Enter the marks - ";
        cin >> marks;
    }

    void display()
    {
        cout << "Rollno - " << rollno << endl;
        Person::display();
        cout << "Marks - " << marks << endl;
    }
};

int main()
{

    Student s1;
    s1.accept();
    s1.display();
    return 0;
}

int main5()
{
    // Upcasting
    Person *p = new Employee(1, "Anil", 10000); // upcasting
    p->display();

    // Downcasting
    Employee *e = dynamic_cast<Employee *>(p);
    if (e != nullptr)
    {
        e->accept();
        e->display();
    }
    else
    {
        cout << "Bad cast" << endl;
    }

    delete p; // Don't forget to free the allocated memory
    return 0;
}

int main4()
{
    Employee *e = new Employee();
    // TO-DO
    e->accept();
    e->display();
    return 0;
}

int main3()
{
    Person *p = new Person();
    // TO-DO
    p->accept();
    p->display();    
    return 0;
}

int main2()
{
    // Employee e1;
    // e1.accept();
    // e1.display();

    Employee e2(2, "Mukesh", 10000);
    e2.display();
    return 0;
}

int main1()
{
    Person p1;
    p1.accept();
    p1.display();

    Person p2("Mukesh");
    p2.display();
    return 0;
}