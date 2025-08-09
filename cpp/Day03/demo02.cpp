#include <iostream>
using namespace std;

class Time
{
    int hr;
    int min;

public:
    // constructor -> initialization of the state of an object
    // parameterless ctor
    Time()
    {
        cout << "Inside Paramterless Ctor" << endl;
        hr = 10;
        min = 10;
    }

    Time(int value)
    {
        cout << "Inside Single Parmeterized Ctor" << endl;
        hr = value;
        min = value;
    }

    Time(int hr, int min)
    {
        cout << "Inside parameterized Ctor" << endl;
        this->hr = hr;
        this->min = min;
    }

    void initTime()
    {
        hr = 10;
        min = 10;
    }
    void display()
    {
        cout << "Time - " << hr << " : " << this->min << endl;
    }
};

int main()
{
    Time t1; // without passing any arguments
    t1.display();
    Time t2;
    t2.display();
    Time t3(11, 30); // by passing the arguments
    Time t4(12, 40);

    t3.display();
    t4.display();

    Time t5(11);
    t5.display();
    return 0;
}
