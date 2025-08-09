#include <iostream>

// Global namespace
int n1 = 10;

// declare a namespace
namespace NA
{
    // Members of the namespace
    int n1 = 30;
    void f1()
    {
    }
    struct Time
    {
    };
}

int main()
{

    int n1 = 20;
    printf("Value of global variable n1 = %d\n", ::n1);
    printf("Value of local variable n1 = %d\n", n1);
    printf("Value of NA variable n1 = %d\n", NA::n1);
    return 0;
}