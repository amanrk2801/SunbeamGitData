#include <iostream>
using namespace std;

// Template class for a dynamic array-like container
// Can store elements of any type T
template <class T>
class myvector {
    T *ptr;       // Pointer to dynamically allocated array of type T
    int size;     // Maximum capacity of the array
    int index;    // Current position (also represents number of elements)

public:
    // Constructor with default size of 5
    myvector(int size = 5)
    {
        this->size = size;    // Set the maximum capacity
        this->index = 0;      // Initialize current position to 0 (empty)
        ptr = new T[size];    // Dynamically allocate array of size 'size'
    }
    
    // Method to add an element to the array
    void addElement(T element)
    {
        if (index < size)     // Check if there's space available
        {
            ptr[index] = element;  // Store element at current position
            index++;              // Increment position for next element
        }
        else
        {
            cout << "myvector is full " << endl;  // Notify if vector is full
        }
    }
    
    // Method to get element at specified index
    T get(int index)
    {
        if (index >= 0 && index < this->index)  // Check if index is valid
            return ptr[index];                 // Return element at specified index
        return NULL;                          // Return NULL for invalid index
    }
    
    // Method to get current number of elements
    int length()
    {
        return index;  // Return current number of elements
    }
    
    // Destructor - cleans up dynamically allocated memory
    ~myvector()
    {
        delete[] ptr;  // Free the dynamically allocated array
        ptr = NULL;    // Set pointer to NULL to avoid dangling pointer
    }
};

// Main function demonstrating myvector with pointers to integers
int main() {
    myvector<int *> v1;               // Create myvector containing pointers to int
    v1.addElement(new int(10));       // Dynamically allocate int with value 10 and add pointer
    v1.addElement(new int(20));       // Dynamically allocate int with value 20 and add pointer
    v1.addElement(new int(30));       // Dynamically allocate int with value 30 and add pointer
    v1.addElement(new int(40));       // Dynamically allocate int with value 40 and add pointer
    v1.addElement(new int(50));       // Dynamically allocate int with value 50 and add pointer
    
    for (int i = 0; i < v1.length(); i++)    // Iterate through all elements
    {
        cout << "Element = " << *v1.get(i) << endl;  // Dereference pointer to get value
    }
    
    // MEMORY LEAK: The dynamically allocated integers are never deleted
    return 0;
}

// Alternative main function demonstrating myvector with integers
int main1() {
    myvector<int> v1;         // Create myvector containing integers
    v1.addElement(10);        // Add integer 10
    v1.addElement(20);        // Add integer 20
    v1.addElement(30);        // Add integer 30
    v1.addElement(40);        // Add integer 40
    v1.addElement(50);        // Add integer 50
    v1.addElement(60);        // Try to add integer 60 (will show "myvector is full")
    
    for (int i = 0; i < v1.length(); i++)    // Iterate through all elements
    {
        cout << "Element = " << v1.get(i) << endl;  // Print each element
    }
    return 0;
}