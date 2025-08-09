#include <iostream>
using namespace std;

class Test
{
    int n1;
    const int n2;

public:
    // constant data members must be initialized inside
    // ctor members initializer list
    Test() : n2(20)
    {
        n1 = 10;
        // n2 = 20; // NOT OK
    }

    void f1() // Test *const this
    {
        n1 = 100;
        // n2 = 200; // NOT OK
    }

    // inside the constant function the state of the object
    // cannot be modified
    void f2() const // const Test *const this
    {
        // n1 = 100; // NOT OK
        // n2 = 200; // NOT OK
    }
};

int main()
{
    Test t1;
    t1.f1();
    t1.f2();

    const Test t2;
    // t2.f1(); // NOT OK
    t2.f2();

    return 0;
}