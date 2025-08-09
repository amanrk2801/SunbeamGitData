#include <iostream>
using namespace std;

class myVector
{
    int *ptr;
    int index;
    int size;

public:
    myVector(int size = 5)
    {
        ptr = new int[size];
        this->size = size;
        this->index = 0;
    }

    void push_back(int element)
    {
        ptr[index] = element;
        index++;
    }

    int &operator[](int i)
    {
        return ptr[i];
    }

    int at(int i)
    {
        return ptr[i];
    }
};

int main()
{
    myVector v1;
    v1.push_back(10);
    v1.push_back(20);

    v1[1] = 200;

    cout << "Element at index 0 = " << v1.at(0) << endl;
    cout << "Element at index 1 = " << v1.at(1) << endl;

    cout << "Element at index 0 using [] = " << v1[0] << endl;
    cout << "Element at index 1 using [] = " << v1[1] << endl;
    return 0;
}