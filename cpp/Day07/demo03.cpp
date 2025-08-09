#include <iostream>
using namespace std;

class Base
{
public:
    Base()
    {
        cout << "Base()" << endl;
    }
    // In C++, a member function is made virtual to enable polymorphism, which allows you to call derived class methods through a base class pointer or reference. This is essential for achieving runtime method binding, where the method that gets called is determined at runtime based on the actual object type, rather than the type of the pointer or reference.
    virtual void f1()
    {
        cout << "Base::f1()" << endl;
    }
    void f2()
    {
        cout << "Base::f2()" << endl;
    }
    // In C++, a virtual destructor ensures that the destructor of the derived class is called when an object is deleted through a pointer to the base class. This is important for proper resource cleanup and to avoid memory leaks.
    virtual ~Base()
    {
        cout << "~Base()" << endl;
    }
};

class Derived : public Base
{
public:
    Derived()
    {
        cout << "Derived()" << endl;
    }
    void f3()
    {
        cout << "Derived::f3()" << endl;
    }
    ~Derived()
    {
        cout << "~Derived()" << endl;
    }
};

int main()
{

    // Base *bptr = new Base();
    // delete bptr;
    // bptr = NULL;

    // Derived *dptr = new Derived();
    // delete dptr;
    // dptr = NULL;

    Base *bptr = new Derived();
    delete bptr;
    bptr = NULL;
    return 0;
}
