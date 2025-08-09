#include <iostream>
using namespace std;

class Base
{public:
    int bnum=20;

public:
    void f1()
    {
        cout << "Base::f1()" << endl;
    }
    void f2()
    {
        cout << "Base::f2()" << endl;
    }
};

class Derived : public Base
{ 
    int dnum=10;
public:
Derived(){}
    void f3()
    {
        cout << "Derived::f3()" << endl;
    }
};

int main1()
{
    // Upcasting is a type of casting in object-oriented programming where a subclass object is treated as an instance of its superclass. This is done to take advantage of polymorphism, allowing a function to operate on objects of different classes through a common interface.
    // Real-life example: Consider a base class 'Animal' and a derived class 'Dog'. If we have a function that accepts an 'Animal' pointer, we can pass a 'Dog' object to it, allowing the function to operate on different types of animals.
    Base *bptr = new Derived(); // upcasting
    bptr->f1();
    bptr->f2();

    // bptr->f3(); // NOT OK -> Object Slicing
    // Object slicing occurs when a derived class object is assigned to a base class object.
    // In this case, the derived class part of the object is "sliced off", and only the base class part is copied.

    // Downcasting is a type of casting in object-oriented programming where a superclass reference or pointer is cast to a subclass reference or pointer. This is done to access subclass-specific members or methods.
    // Real-life example: Consider a base class 'Employee' and a derived class 'Manager'. If we have a list of employees and we know that some of them are managers, we can downcast to access manager-specific methods.
    Derived *dptr = (Derived *)bptr; // Downcasting
    dptr->f3();
    
    return 0;
}

int main()
{
    Base *bptr = new Base();
    bptr->f1();
    bptr->f2();
    
    Derived *dptr = new Derived();
    dptr->f1();
    dptr->f2();
    dptr->f3();

    // int *ptr1 = (int *)malloc(1 * sizeof(int));
    return 0;
}
