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

class Derived
{
public:
    void f3()
    {
        cout << "Derived::f3()" << endl;
    }
};

int main()
{
    Base *bptr = new Base();
    bptr->f1();
    bptr->f2();

    // Derived *dptr = (Derived *)bptr;
    
    // Attempting to downcast Base pointer to Derived pointer using reinterpret_cast
    Derived *dptr = reinterpret_cast<Derived *>(bptr);
    if (dptr != NULL)
        dptr->f3();
    else
        cout << "Downcasting is not possible" << endl;

    cout << "Program finished" << endl;
    return 0;
}