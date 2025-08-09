#include <iostream>
using namespace std;

// template <typename X, typename Y>
template <class X, class Y>
class Point
{
private:
    X x;
    Y y;

public:
    Point()
    {
    }
    Point(X x, Y y)
    {
        this->x = x;
        this->y = y;
    }
    void display()
    {
        cout << "Point (" << x << "," << y << ")" << endl;
    }
};

int main()
{
    Point<int, int> p1(2, 3);
    p1.display();

    Point<double, double> p2(2.5, 3.2);
    p2.display();

    Point<char, int> p3('A', 30);
    p3.display();

    Point<char, double> p4('A', 65.78);
    p4.display();

    return 0;
}