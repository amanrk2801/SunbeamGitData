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

        // overloading as a  member function
    Time operator+(Time &t2) // this-> t1
    {
        Time t3;
        t3.hr = this->hr + t2.hr;
        t3.min = this->min + t2.min;
        return t3;
    }
};

int main()
{
    Time t1; // parameterless ctor
    t1.display();

    Time t2(11, 30); // parameterized ctor
    t2.display();

    Time t3 = t1 + t2; // t1.operator+(t2)
    t3.display();

    return 0;
}