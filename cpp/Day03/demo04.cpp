#include <iostream>
using namespace std;
class Test
{
    int x;
    int y;

public:
    // ctor members initializer list
    Test() : y(++x), x(5)
    {
    }

    void display()
    {
        cout << "x = " << x << endl;
        cout << "y = " << y << endl;
    }
};
int main()
{
    Test t1;
    t1.display();
    return 0;
}
