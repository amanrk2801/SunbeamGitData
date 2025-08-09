#include <iostream>
using namespace std;
class Time
{
    int hr;
    int min;

public:
    Time()
    {
        cout << "Time()" << endl;
        hr = 10;
        min = 10;
    }

    Time(int hr, int min)
    {
        cout << "Time(int,int)" << endl;
        this->hr = hr;
        this->min = min;
    }

    void display()
    {
        cout << "Time - " << hr << " : " << min << endl;
    }

    void operator()()
    {
        cout << "Inside Operator()" << endl;
        cout << "Time - " << hr << " : " << min << endl;
    }
};

void f1()
{
}

int main()
{
    Time t1; // parameterless ctor -> Function Objects(Functors)

    Time t2(11, 30); // parameterized ctor

    // t1.display();
    // t2.display();

    // f1();
    t1(); // t1.operator()()
    t2();
    return 0;
}