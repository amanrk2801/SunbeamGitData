#include <iostream>
using namespace std;

void division(int n, int d)
{
    if (d == 0)
        throw 1; // throw an int type of exception
    int result = n / d;
    cout << "Division - " << result << endl;
}

int main()
{
    try
    {
        division(10, 0);
    }
    catch (int e)
    {
        cout << "Division by 0 is not possible..." << endl;
    }
    cout << "Program finished..." << endl;
    return 0;
}