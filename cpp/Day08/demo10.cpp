#include <iostream>
using namespace std;

/**
 * @class Base
 * @brief A base class with private, protected, and public members.
 *
 * This class demonstrates the use of different access specifiers in C++.
 * It contains private, protected, and public integer members, and a public
 * member function to display these members. It also declares a friend class.
 *
 * @var Base::n1
 * Private integer member, not accessible outside the class.
 *
 * @var Base::n2
 * Protected integer member, accessible in derived classes.
 *
 * @var Base::n3
 * Public integer member, accessible from outside the class.
 *
 * @fn Base::displayBase()
 * Public member function to display the values of n1, n2, and n3.
 *
 * @friend class Derived
 * Declares the Derived class as a friend, allowing it to access private and protected members of Base.
 */
class Base
{
private:
    int n1;

protected:
    int n2;

public:
    int n3;

    void displayBase()
    {
        cout << n1 << n2 << n3 << endl;
    }
    friend class Derived;
};

class Derived : public Base
{
public:
    void displayDerived()
    {
        cout << n1 << n2 << n3 << endl;
    }
};

int main()
{

    return 0;
}