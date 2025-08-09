#include <iostream>
using namespace std;

class Base
{
    int n1;
};

class Derived : Base
{
    int n2;
};

int main()
{
    cout << "Size of Base = " << sizeof(Base) << endl;
    cout << "Size of Derived = " << sizeof(Derived) << endl;

    return 0;
}