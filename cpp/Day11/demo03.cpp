#include <iostream>
using namespace std;

class Singleton
{
    // step-2 declare a static ptr of the Singleton type
    static Singleton *ptr;

private:
    // step-1 Make the ctor as private
    Singleton()
    {
        cout << "Singleton() called" << endl;
    }

public:
    // step-3 : create a static function that will return the instance
    // of this class
    static Singleton *getInstance()
    {
        // step-4 : check for the ptr if its null and then create the
        // instance and return it
        if (ptr == NULL)
            ptr = new Singleton();
        return ptr;
    }
};

// step-2 : and initialize it on the global scope with the NULL
Singleton *Singleton::ptr = NULL;

int main()
{
    Singleton *s1 = Singleton::getInstance();
    Singleton *s2 = Singleton::getInstance();
    Singleton *s3 = Singleton::getInstance();
    Singleton *s4 = Singleton::getInstance();
    return 0;
}