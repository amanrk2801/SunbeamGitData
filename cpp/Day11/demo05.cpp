#include <iostream>
using namespace std;

void f1(int n)
{
    cout << "f1(int)" << endl;
}

void f1(int *ptr)
{
    cout << "f1(int*)" << endl;
}

int main()
{
    int n1 = 10;
    f1(n1);
    // f1(NULL); // NOT OK
    f1(0); // Correct Way

    f1(&n1);
    // f1(NULL); // NOT OK
    f1(nullptr); // correct way
    return 0;
}

int main2()
{
    int n1;
    double n2;
    int *n3;

    n1 = NULL;
    // n2 = nullptr; // NOT OK
    n3 = nullptr;
    // null ptr is used to make only the pointers as null;
    return 0;
}

int main1()
{
    int n1 = NULL;
    double n2 = NULL;
    int *ptr = NULL;
    return 0;
}