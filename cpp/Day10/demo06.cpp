#include <iostream>
using namespace std;

class Time
{
private:
    int *hr;
    int *min;

public:
    Time()
    {
        cout << "Time()" << endl;
        hr = new int(10);
        min = new int(10);
    }
    Time(int h, int m)
    {
        cout << "Time(int,int)" << endl;
        hr = new int(h);
        min = new int(m);
    }

    // Copy ctor
    // single paramerized ctor
    // parameter is of the same type as that of the class
    // and it accepts the parameter by reference
    Time(Time &t2) // this-> t3
    {
        cout << "Copy Ctor" << endl;
        hr = new int(*t2.hr);
        min = new int(*t2.min);
    }

    void display()
    {
        cout << "Time - " << *hr << " : " << *min << endl;
    }

    void setHr(int h)
    {
        *hr = h;
    }
    void setMin(int m)
    {
        *min = m;
    }
    ~Time()
    {
        cout << "Dtor" << endl;
        delete hr;
        delete min;
    }
};

int main()
{
    Time t1; // parameterless ctor
    t1.display();

    Time t2(11, 30); // parameterized ctor
    t2.display();

    Time t3 = t2; // t3.Time(t2) Copy Ctor -> Deep Copy
    t3.display();

    t3.setMin(40);
    cout << "After change in t3 - >" << endl;
    t2.display();
    t3.display();
    return 0;
}