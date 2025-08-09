#include <iostream>
using namespace std;
class Time
{
    // Data Members
    int hr;
    int min;

public:
    // Member Functions
    void accept()
    {
        cout << "Enter the hrs - ";
        cin >> hr;
        cout << "Enter the mins - ";
        cin >> min;
    }

    void display()
    {
        cout << "Time - " << hr << " : " << min << endl;
    }
};

int main()
{
    cout << "Hello World" << endl;
    std::cout << "Hello from karad" << std::endl;
    Time t1;
    cout << "Size of Time = " << sizeof(Time) << endl;
    cout << "Address of t1 = " << &t1 << endl;
    t1.accept();
    t1.display();
    return 0;
}