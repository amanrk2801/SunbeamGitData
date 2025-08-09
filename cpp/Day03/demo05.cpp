#include <iostream>
using namespace std;
class Point
{
    int x;
    int y;

public:
    Point()
    {
        cout << "Inside Parameterless ctor" << endl;
        x = 1;
        y = 1;
    }

    Point(int x, int y)
    {
        cout << "Inside Parameterized ctor" << endl;
        this->x = x;
        this->y = y;
        display();
    }

    void display()
    {
        cout << "Point(" << x << "," << y << ")" << endl;
    }
    // Destructor
    ~Point()
    {
        cout << "Inside Destructor" << endl;
        display();
    }
};
int main()
{
    Point p1(2, 3);
    Point p2(4, 5);
    Point p3(6, 7);
    return 0;
}