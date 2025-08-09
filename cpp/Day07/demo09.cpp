#include <iostream>
using namespace std;

class Base
{
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
public:
    void f3()
    {
        cout << "Derived::f3()" << endl;
    }
};

int main()
{
    // Static_cast does not need to upcast the base pointer; it directly gets the values from the derived class.
    Base *bptr = new Base();
    bptr->f1();
    bptr->f2();

    // We use static_cast for downcasting in C++ to convert a pointer or reference of a base class type to a derived class type. This is necessary when you need to access members or methods that are specific to the derived class.
    Derived *dptr = static_cast<Derived *>(bptr); // Downcasting
    if (dptr != NULL)
        dptr->f3();
    else
        cout << "Downcasting is not possible" << endl;

    cout << "Program finished" << endl;
    return 0;
}