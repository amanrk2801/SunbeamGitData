#include <iostream>
using namespace std;

class Time
{
    int hr;
    int min;

public:
    Time() : Time(10, 10) // ctor delegation
    {
        // hr = 10;
        // min = 10;
    }

    Time(int hr, int min)
    {
        this->hr = hr;
        this->min = min;
    }

    void display()
    {
        cout << "Time - " << hr << " : " << this->min << endl;
    }
};

int main()
{
    Time t1(11, 30);
    t1.display();

    Time t2;
    t2.display();
    return 0;
}
