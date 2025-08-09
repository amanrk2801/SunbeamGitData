#include <iostream>
using namespace std;
class Test
{
    int x;
    int y;

public:
    Test() : Test(1, 1) {}

    // ctor members initializer list
    Test(int x, int y) : x(x), y(y)
    {
        this->x = 5;
        this->y = 6;
    }

    void display()
    {
        cout << "x = " << x << endl;
        cout << "y = " << y << endl;
    }
};
int main()
{
    Test t1(2, 3);
    t1.display();
    return 0;
}
