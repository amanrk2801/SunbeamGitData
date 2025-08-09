#include <iostream>
using namespace std;

class InvalidTimeException
{
private:
    string message;

public:
    InvalidTimeException()
    {
        message = "";
    }

    InvalidTimeException(string message)
    {
        this->message = message;
    }

    void printStackTrace()
    {
        cout << "InvalidTimeException : " << message << endl;
    }
};

class Employee
{
};

class Time
{
private:
    int hr;
    int min;

public:
    void setHr(int hr)
    {
        if (hr < 0 || hr > 23)
            throw InvalidTimeException("Hrs between 0-23");
        this->hr = hr;
    }
    void setMin(int min)
    {
        if (min < 0 || min > 59)
            throw InvalidTimeException("min should be between 0 and 59");
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
        t.setMin(60);
        t.display();
    }
    catch (InvalidTimeException ref)
    {
        ref.printStackTrace();
    }

    cout << "Program finished..." << endl;
    return 0;
}