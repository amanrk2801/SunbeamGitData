#include <iostream>
using namespace std;

class A
{
private:
    int n1;

public:
    A()
    {
        n1 = 10;
        cout << "A()" << endl;
    }
    void displayA()
    {
        cout <<"from class A "<< n1 << endl;
    }

    int getN1()
    {
        return n1;
    }
};

class B : public A
{
private:
    int n2;

public:
    B()
    {
        n2 = 20;
        cout << "B()" << endl;
    }
    void displayB()
    {
        cout << "from class B, n1 = " << getN1() << endl;
        this->displayA();
        cout << "from class B, n2 = " << n2 << endl;
    }
};

int main()
{
    B b;
    b.displayA();
    b.displayB();
    b.getN1();
    return 0;
}