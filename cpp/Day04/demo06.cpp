#include <iostream>
using namespace std;
class Point
{
    int x;
    int y;

public:
    Point()
    {
        cout << "Inside Ctor" << endl;
    }
    ~Point()
    {
        cout << "Inside Dtor" << endl;
    }
};

int main()
{
    // Point p1;
    Point *p = new Point; // heap
    delete p;
    p = NULL;
    return 0;
}
int main1()
{
    int *ptr = new int; // heap
    *ptr = 10;
    cout << "Value at *ptr = " << *ptr << endl;
    delete ptr;
    ptr = NULL;
    return 0;
}