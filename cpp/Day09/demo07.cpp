#include <iostream>
using namespace std;

int n3 = 30;
void f1()
{
    int n4 = 40;
    static int n5 = 50;
    class Local
    {
        int n1;
        // static int n2; // NOT OK

    public:
        void f1()
        {
            cout << n3 << endl;
            cout << n4 << endl;
        }

        static void f2()
        {
            cout << n3 << endl;
            cout << n4 << endl;
        }
    };

    Local l1;
    l1.f1();
    l1.f2();
}
int main()
{
    f1();
    return 0;
}

// 1. class created inside the function is called as local class
// 2. object of the local class can be created only in the function
//  inside which it is declared
// 3. inside local class we cannot declare static data members
// 4. However we can define static member functions
// 5. we can access the global variables inside the local class however
// we cannot access the local variables
// 6. we cannot declare the local class as static