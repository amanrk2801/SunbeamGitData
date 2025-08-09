#include <iostream>
using namespace std;

int main()
{
    int *ptr = new int;
    *ptr = 10;
    cout << "value at heap = " << *ptr << endl;
    // delete ptr;
    // ptr = NULL;
    return 0;
}