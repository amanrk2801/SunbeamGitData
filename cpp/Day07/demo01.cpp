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
    // function overriding
    void f2()
    {
        cout << "Derived::f2()" << endl;
    }

    void f3()
    {
        cout << "Derived::f3()" << endl;
    }
};

int main1()
{

    Base *bptr = new Derived();
    bptr->f2();//! Early Binding - Base::f2 - Early binding (static binding) resolves function calls at compile time, using function overloading, normal function calls, or operator overloading for fast execution.
    Derived *dptr = (Derived *)bptr; // Downcasting
    dptr->f2(); // achieve with overiding 
    return 0;
}

int main()
{
    Base *bptr = new Derived(); //! Upcasting : Upcasting is converting a derived class pointer/reference to a base class pointer/reference, enabling access to base class members only.
    bptr->f1();
    bptr->f2();
    // bptr->f3(); //! OBJECT SLICING : Object slicing occurs when a derived class object is assigned to a base class object, causing the derived class-specific attributes to be lost.
    Derived *dptr = (Derived *)bptr; //! Downcasting : Downcasting is converting a base class pointer/reference to a derived class pointer/reference, requiring explicit casting and usually dynamic_cast for safety.
    dptr->f3();
    return 0;
}

//! Early Binding (Static Binding)
// Definition:
// The function call is resolved at compile time.
// Uses function overloading and function overriding (without virtual functions).
// Achieved using normal function calls, operator overloading, and default function calls.
// How it Works:
// The compiler knows at compile time which function to call.
// Fast execution because no runtime lookup is needed.

//! Late Binding (Dynamic Binding)
// Definition:
// The function call is resolved at runtime.
// Uses virtual functions and polymorphism.
// The function being called is determined by the actual object type, not the pointer/reference type.
// How it Works:
// The function address is stored in a vtable (Virtual Table).
// The compiler generates code to look up the function in the vtable at runtime.