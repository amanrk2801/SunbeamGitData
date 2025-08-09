#include <iostream>
using namespace std;

int main4()
{
    // Optional to Try
    int ***ptr = new int **[2];
    ptr[0] = new int *[3];
    // ptr[0][0] = new int(10);
    // OR
    // ptr[0][0] = new int[3];
}

int main()
{
    int **ptr = new int *[2];
    ptr[0] = new int[3];
    ptr[1] = new int[3];
    ptr[0][0] = 10;
    ptr[0][1] = 20;
    ptr[0][2] = 30;
    ptr[1][0] = 40;
    ptr[1][1] = 50;
    ptr[1][2] = 60;

    for (int i = 0; i < 2; i++)
    {
        for (int j = 0; j < 3; j++)
            cout << "Element = " << ptr[i][j] << endl;
    }

    // for deallocation
    for (int i = 0; i < 2; i++)
    {
        delete[] ptr[i];
        ptr[i] = NULL;
    }

    delete[] ptr;
    ptr = NULL;
    return 0;
}

int main2()
{
    int *arr[2][3];
    arr[0][0] = new int(10);
    // TO-DO
    return 0;
}

int main1()
{
    int arr[2][3]; // stack
    arr[0][0] = 10;
    arr[0][1] = 20;
    arr[0][2] = 30;
    arr[1][0] = 40;
    arr[1][1] = 50;
    arr[1][2] = 60;

    for (int i = 0; i < 2; i++)
    {
        for (int j = 0; j < 3; j++)
            cout << "Element = " << arr[i][j] << endl;
    }
    return 0;
}