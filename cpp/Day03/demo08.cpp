#include <iostream>
using namespace std;

int main5()
{

    int num1 = 10;
    const int *ptr;
    ptr = &num1;
    num1 = 20;
    int num2 = 30;
    ptr = &num2;
    //*ptr = 40; // NOT OK
    return 0;
}

int main4()
{
    const int num1 = 10;
    const int *const ptr = &num1;
    // num1 = 20; //NOT OK
    // *ptr = 20;//NOT OK
    int num2 = 30;
    // ptr = &num2;//NOT OK
    return 0;
}
int main3()
{
    int num1 = 10;
    int *const ptr = &num1;
    num1 = 20;
    *ptr = 200;
    int num2 = 30;
    // ptr = &num2; // NOT OK
    return 0;
}

int main2()
{
    const int num1 = 10;
    // const int *ptr = &num1;
    int const *ptr = &num1;
    // num1 = 20; /// NOT OK
    //*ptr = 20; // NOT OK
    int num2 = 30;
    ptr = &num2;
    return 0;
}

int main1()
{
    const int num1 = 10;
    // num1 = 20; // NOT OK
    return 0;
}