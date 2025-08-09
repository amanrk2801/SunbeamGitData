#include <iostream>
using namespace std;

class Time
{
    int hr;
    int min;

public:
    // facilitators
    void accept()
    {
        cout << "Enter the hrs - ";
        cin >> hr;
        cout << "Enter the mins - ";
        cin >> min;
    }
    void display()
    {
        cout << "Time - " << hr << " : " << min << endl;
    }
    // function that manipulates single data member value
    // by taking the value in the parameter,
    // such functions are called as Mutators
    void setMin(int min)
    {
        this->min = min;
    }

    void setHr(int hr)
    {
        this->hr = hr;
    }

    // A function that is designed to return the value of
    // single data member of the class is called as Inspector
    // Inspectors (getters)
    int getHr()
    {
        return hr;
    }

    int getMin()
    {
        return min;
    }
};

int main()
{
    Time t1;
    t1.accept();
    t1.display();
    // t1.min = 52;
    t1.setMin(52);

    // cout << "t1.hrs = " << t1.hr << endl;
    cout << "t1.hrs = " << t1.getHr() << endl;

    t1.setHr(10);
    cout << t1.getHr();
    return 0;
}
