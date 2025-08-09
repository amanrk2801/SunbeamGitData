#include <iostream>
using namespace std;

class Test
{
private:
    int n1;
    static int n2;

public:
    Test()
    {
        n1 = 10;
    }
    void f1()
    {
        cout << "Inside f1()" << endl;
        cout << n1 << n2 << endl;
    }

    static void f2()
    {
        cout << "Inside f2()" << endl;
        cout << n1 << n2 << endl;
    }

    void display()
    {
        cout << "N1 = " << n1 << endl;
        cout << "N2 = " << n2 << endl;
    }
};
// static data members must be initialized outside the class
// on global scope using class name and scope resolution operator
int Test::n2 = 20;

int main()
{
    Test t1;
    Test t2;
    Test t3;

    cout << "Size of Test = " << sizeof(Test) << endl;
    t1.display();

    t1.f1();
    t2.f1();
    t3.f1();

    Test::f2(); // static member functions to be called using classname and ::

    return 0;
}