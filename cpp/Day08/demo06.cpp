#include <iostream>
using namespace std;
template <typename T>
void myswap(T &n1, T &n2)
{
    T temp = n1;
    n1 = n2;
    n2 = temp;
}

int main()
{
    // int n1 = 10;
    // int n2 = 20;
    // double n1 = 10.11;
    // double n2 = 20.25;
    char n1 = 'A';
    char n2 = 'B';
    cout << "Before swapping - n1 = " << n1 << ", n2 = " << n2 << endl;
    myswap(n1, n2);
    cout << "After swapping - n1 = " << n1 << ", n2 = " << n2 << endl;
    return 0;
}