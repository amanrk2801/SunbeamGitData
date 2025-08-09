#include <iostream>
using namespace std;

class Base
{
private:
    int n1;

public:
    Base()
    {
        cout << "Base()" << endl;
    }
    void f1()
    {
        cout << "Base::f1()" << endl;
    }
    void f2()
    {
        cout << "Base::f2()" << endl;
    }
    ~Base()
    {
        cout << "~Base()" << endl;
    }
};

class Derived : public Base
{
private:
    int n2;

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
    Derived d;
    d.f1();
    d.f2();
    d.f3();
    return 0;
}

int main1()
{
    Base b;
    b.f1();
    b.f2();
    // b.n1; // NOT OK
    return 0;
}