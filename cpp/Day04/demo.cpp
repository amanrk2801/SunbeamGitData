#include <iostream>
using namespace std;

int main() {
    // Allocate memory for a single integer
    int *singlePtr = new int;
    *singlePtr = 42;
    cout << "Value pointed to by singlePtr: " << *singlePtr << endl;
    cout << "Address stored in singlePtr: " << singlePtr << endl;

    // Allocate memory for an array of integers
    int *arrayPtr = new int[5];
    for (int i = 0; i < 5; ++i) {
        arrayPtr[i] = i * 10;
    }

    cout << "Array values: ";
    for (int i = 0; i < 5; ++i) {
        cout << arrayPtr[i] << " ";
    }
    cout << endl;

    // Free the allocated memory
    delete singlePtr;
    delete[] arrayPtr;

    return 0;
}