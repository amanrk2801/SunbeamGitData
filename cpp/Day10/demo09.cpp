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
    friend void operator<<(ostream &out, Time &t);
    friend void operator>>(istream &in, Time &t);
};

void operator<<(ostream &out, Time &t)
{
    out << "Time - " << endl;
    out << "hr - " << t.hr << endl;
    out << "min - " << t.min << endl;
}

void operator>>(istream &in, Time &t)
{
    in >> t.hr >> t.min;
}

int main()
{
    Time t1;
    cout << "Enter the time - ";
    cin >> t1; // operator>>(cin,t1)
    // cin >> t1.hr >> t1.min;
    cout << t1; // operator<<(cout,t1)
    return 0;
}