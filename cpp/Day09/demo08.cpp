#include <iostream>
using namespace std;

class Outer
{
    int n1;
    static int n2;

public:
    // Nested class
    class Inner
    {
        int n3;
        static int n4;

    public:
        void if1()
        {
            Outer o1;
            cout << o1.n1 << endl; // OK
            // cout << n1 << endl; // NOT OK
            cout << n2 << endl;
            cout << n3 << endl;
            cout << n4 << endl;
        }
        static void if2()
        {
            Outer o1;
            cout << o1.n1 << endl; // OK
            // cout << n1 << endl; // NOT OK
            cout << n2 << endl;
            // cout << n3 << endl; // NOT OK
            cout << n4 << endl;
        }
    };

    void of1()
    {
    }
    static void of2()
    {
    }
};

int main()
{
    Outer o1;
    Outer::Inner i1;
    return 0;
}

// 1. A class inside another class is called as nested class
// 2. we cannot make the nested class as static
// 3. We can declare static as well as nonstatic data members and
// member functions inside the nested class.
// 4. Inside the nested class we can access the static data members of the
// outer class directly
// 5. However we cannot access the non static data members of the outer class
// directly inside nested class. to access them we have to create object
/// of the outer class
// 6. To create the object of the nested class we have to outer class name
// and scope resolution operator