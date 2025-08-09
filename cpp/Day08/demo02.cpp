#include <iostream>
using namespace std;

class Test {
    // mutable members can be modified even in const methods
    mutable int n1;
    
    // const members can never be modified after initialization
    const int n2;
    
    // regular member variable
    int n3;

public:
    // Constructor initializes all members
    // const members MUST be initialized in the initializer list
    Test() : n2(20)
    {
        n1 = 10;
        n3 = 30;
    }

    // const method - promises not to modify the object's state
    // compiler passes 'this' as 'const Test *const this'
    void f1() const
    {
        n1 = 100; // OK - mutable members can be modified in const methods
        // n2 = 200; // NOT OK - n2 is const, can never be modified
        
        // for n3(regular) => Because the object is treated as const, you can't modify any regular members
        // Using const_cast to remove const-ness and modify n3
        // This is generally bad practice but works
        const_cast<Test *>(this)->n3 = 300; // OK after const_cast
        
        cout << "f1(): n1=" << n1 << ", n2=" << n2 << ", n3=" << n3 << endl;
    }
    
    // Non-const method - can modify the object's state
    // compiler passes 'this' as 'Test *const this'
    void f2()
    {
        n1 = 30; // OK - can modify regular members in non-const methods
        // n2 = 200; // NOT OK - n2 is const, can never be modified
        n3 = 300; // OK - can modify regular members in non-const methods
        
        cout << "f2(): n1=" << n1 << ", n2=" << n2 << ", n3=" << n3 << endl;
    }
    
    // const method - promises not to modify the object's state
    void f3() const
    {
        n1 = 40;  // OK - mutable members can be modified in const methods
        // n3 = 300; // NOT OK - n3 is non-mutable and method is const
        // Would need const_cast like in f1() to modify n3
        
        cout << "f3(): n1=" << n1 << ", n2=" << n2 << ", n3=" << n3 << endl;
    }
    
    // Helper method to display values
    void display() const 
    {
        cout << "Current values: n1=" << n1 << ", n2=" << n2 << ", n3=" << n3 << endl;
    }
};

int main() {
    Test t;
    cout << "After construction:" << endl;
    t.display();
    
    cout << "\nCalling f1():" << endl;
    t.f1();
    t.display();
    
    cout << "\nCalling f2():" << endl;
    t.f2();
    t.display();
    
    cout << "\nCalling f3():" << endl;
    t.f3();
    t.display();
    
    return 0;
}