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

    // Constructor
    Time(int mins) // conversion function
    {
        cout << "Time(int)" << endl;
        this->hr = mins / 60;
        this->min = mins % 60;
    }

    void display()
    {
        cout << "Time - " << hr << " : " << min << endl;
    }
    // conversion function
    operator int()
    {
        int mins = 0;
        mins = hr * 60 + min;
        return mins;
    }
};

int main()
{
    Time t1(11, 40); // parameterized ctor
    int mins = t1;   // Time Type -> int type (conversion function will be called)
    cout << "Mins = " << mins << endl;
    return 0;
}

int main2()
{
    Time t1;
    t1 = 140; // int type -> Time type
    t1.display();

    return 0;
}

int main1()
{
    Time t1;         /// Parameterless Ctor
    Time t2(11, 40); // Parameterized ctor
    Time t3(130);    // single paramaterized ctor

    Time t4 = t2; // Default Copy Ctor
    Time t5;      // Paramaterless ctor
    t5 = t3;      // Default Assignment Opertor function

    return 0;
}