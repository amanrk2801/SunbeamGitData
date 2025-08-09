#include <iostream>

class Time
{
    int hr;
    int min;

public:
    void accept() // this
    {
        // address of the current calling object
    }

    void display()
    {
    }
};

int main()
{
    Time t1;
    // address of the object t1

    Time t2;
    // address of the object t2

    t1.accept();
    t2.accept();

    return 0;
}