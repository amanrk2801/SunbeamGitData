#include <iostream>
#include <vector>
using namespace std;

template <class T>
class Point
{
};

int main()
{
    Point<int> p1;
    // cout << p1[0] << endl; // NOT OK unless we overload [] operator

    vector<int> v1;   // dyanmic array
    v1.push_back(10); // add the element in the vector
    v1.push_back(20);
    v1.push_back(30);
    v1.push_back(40);
    v1.push_back(50);

    // It represents the no of elements it can store
    cout << "Capacity - " << v1.capacity() << endl;

    // It represents actual no of elements present inside the vector
    cout << "Size - " << v1.size() << endl;

    // v1.pop_back(); // remove the last element added from the vector
    // v1.erase(v1.begin()); // It will remove the first element from the vector
    // v1.erase(v1.begin() + 2); // It will remove the element at the required index

    for (int i = 0; i < v1.size(); i++)
    {
        // cout << "Element = " << v1.at(i) << endl;
        cout << "Element = " << v1[i] << endl;
    }

    // iterator -> Random Access Iterator
    for (vector<int>::iterator itr = v1.begin(); itr != v1.end(); itr++)
    {
        cout << "Element uisng itr = " << *itr << endl;
    }
    return 0;
}