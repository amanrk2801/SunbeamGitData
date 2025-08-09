#include <iostream>
using namespace std;

void f1(int n) // n is a variable
{
    n = 20;
}

void f2(int *n) // n is a pointer
{
    *n = 20;
}

void f3(int &n) // n is a reference
{
    n = 20;
}

int main()
{
    int num1 = 10;
    int num2 = 20;
    // int &ref; // NOT OK.. It must be initialized with referent
    int &ref = num1; // OK
    cout << "Before, Num1 = " << num1 << endl;
    ref = num2; // the value of num2 is copied inside num1.
    // the referent of the reference once initialized cannot be changed

    cout << "After, Num1 = " << num1 << endl;

    // int &ref = new int; // NOT OK
    int *ref = new int; // OK

    return 0;
}

int main3()
{
    int num1 = 10;
    cout << "Value of num1 before change = " << num1 << endl;
    f3(num1); // pass by reference
    cout << "Value of num1 after change = " << num1 << endl;
    return 0;
}

int main2()
{
    int num1 = 10;
    cout << "Value of num1 before change = " << num1 << endl;
    f2(&num1); // pass by address
    cout << "Value of num1 after change = " << num1 << endl;
    return 0;
}

int main1()
{
    int num1 = 10;
    cout << "Value of num1 before change = " << num1 << endl;
    f1(num1); // pass by value
    cout << "Value of num1 after change = " << num1 << endl;
    return 0;
}