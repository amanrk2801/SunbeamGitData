#include <iostream>
using namespace std;

class Time
{
private:
    int hr;
    int min;

public:
    Time()
    {
        hr = 10;
        min = 10;
    }
    Time(int hr, int min)
    {
        this->hr = hr;
        this->min = min;
    }

    void display()
    {
        cout << "Time - " << hr << " : " << min << endl;
    }
    friend Time operator+(Time &t1, Time &t2);
};

// overloading as a non member function
Time operator+(Time &t1, Time &t2)
{
    Time t3;
    // t3.setHr(t1.getHr()+t2.getHr());
    t3.hr = t1.hr + t2.hr;
    t3.min = t1.min + t2.min;
    return t3;
}

int main()
{
    Time t1; // parameterless ctor
    t1.display();

    Time t2(11, 30); // parameterized ctor
    t2.display();

    Time t3 = t1 + t2; // operator+(t1,t2)
    t3.display();

    return 0;
}