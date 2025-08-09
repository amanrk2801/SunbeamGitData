#include <iostream>
using namespace std;

class Base
{
private:
    int n1 = 10;

protected:
    int n2 = 20;

public:
    int n3 = 30;

    void displayBase()
    {
        cout << n1 <<" "<< n2 <<" "<< n3 << endl;
    }
};
// Mode of inheritance
// Default mode of inheritance is private
class Derived : public Base
{
public:
    void displayDerived()
    {
        // cout << n1 << endl; // error : member "Base::n1" (declared at line 7) is inaccessible
        cout << n2 <<" "<< n3 << endl;
    }
};

class Indirect : Derived
{
    void displayIndirect()
    {
        // cout << n1 << endl; // member "Base::n1" (declared at line 7) is inaccessible
        cout << n2 << n3 << endl;
    }
};

int main()
{
    Base b;
    // b.n1; // NOT OK
    // b.n2; // NOT OK
    b.n3; // OK
    b.displayBase();
    
    Derived d;
    d.displayDerived();
    // d.n1; // NOT OK
    // d.n2; // NOT OK
    d.n3; //
    return 0;
}