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

    void setHr(int hr)
    {
        this->hr = hr;
    }
    void setMin(int min)
    {
        this->min = min;
    }
};

int main()
{
    Time t1; // parameterless ctor
    t1.display();

    Time t2(11, 30); // parameterized ctor
    t2.display();

    Time t3 = t2; // Default Copy Ctor -> Shallow Copy
    t3.display();

    t3.setMin(40);
    cout << "After change in t3 - >" << endl;
    t2.display();
    t3.display();
    return 0;
}