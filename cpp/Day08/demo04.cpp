#include <iostream>
using namespace std;

class Time
{
private:
    int hr;
    int min;

public:
    void setHr(int hr)
    {
        if (hr < 0 || hr > 23)
            throw 3; // int type of exception
        this->hr = hr;
    }
    void setMin(int min)
    {
        if (min < 0 || min > 59)
            throw 6.8; /// double type of exception
        this->min = min;
    }

    void display()
    {
        cout << "Time - " << hr << " : " << min << endl;
    }
};

int main()
{
    Time t;
    try
    {
        t.setHr(10);
        t.setMin(20);
        t.display();
    }
    catch (...) // Generic Catch Block
    {
        cout << "Something went wrong ..." << endl;
    }
    cout << "Program finished" << endl;
    return 0;
}

int main1()
{
    Time t;
    try
    {
        t.setHr(10);
        t.setMin(70);
        t.display();
    }
    catch (int e)
    {
        cout << "Hrs should be between 0 to 23" << endl;
    }
    catch (double e)
    {
        cout << "Mins should be between 0 to 59" << endl;
    }

    cout << "Program finished" << endl;
    return 0;
}