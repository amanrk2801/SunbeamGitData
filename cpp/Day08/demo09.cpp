#include <iostream>
using namespace std;

// Define a class named Test
class Test
{
private:
    int n1; // Private member variable, accessible only within the class

protected:
    int n2; // Protected member variable, accessible within the class and derived classes

public:
    int n3; // Public member variable, accessible from anywhere

    // Public member function to display the values of n1, n2, and n3
    void display()
    {
        cout << n1 << n2 << n3 << endl;
    }

    // Declare a friend function f1, which can access private and protected members of the class
    friend void f1();
};

// Definition of the friend function f1
// Friend functions do not get the 'this' pointer and can access private and protected members of the class
void f1()
{
    Test t; // Create an object of class Test
    // Access and print the private, protected, and public members of the object
    cout << t.n1 << t.n2 << t.n3 << endl;
}

int main()
{
    Test t; // Create an object of class Test
    // The following line is commented out because it would cause a compilation error
    // Private and protected members cannot be accessed directly from outside the class
    // cout << t.n1 << t.n2 << t.n3 << endl;
    
    // Access and print the public member n3
    cout << t.n3 << endl;
    return 0;
}