#include <iostream>
using namespace std;

class Base
{
public:
    void f1()
    {
        cout << "Base::f1()" << endl;
    }
     virtual void f2()
    {
        cout << "Base::f2()" << endl;
    }
};

class Derived : public Base
{
public:
    void f3()
    {
        cout << "Derived::f3()" << endl;
    }
};

int main1()
{
    Base *bptr = new Base();
    bptr->f1();
    bptr->f2();

    // the operand of a runtime dynamic_cast must have a polymorphic class type
    Derived *dptr = dynamic_cast<Derived *>(bptr); // Downcasting
    if (dptr != NULL)
        dptr->f3();
    else
        cout << "Downcasting is not possible" << endl;

    cout << "Program finished" << endl;
    return 0;
}

int main()
{
    // dynamic_cast is used for safe downcasting from base pointer to derived pointer.
    Base *bptr = new Derived(); // Now bptr actually points to a Derived object
    bptr->f1();
    bptr->f2();

    Derived *dptr = dynamic_cast<Derived *>(bptr); // Safe downcasting
    if (dptr != NULL)
        dptr->f3();
    else
        cout << "Downcasting is not possible" << endl;

    delete bptr; // Always free allocated memory
    cout << "Program finished" << endl;
    return 0;
}