#include <iostream>

struct Time
{
private: // access specifier
    // Data Members
    int hr;
    int min;

public:
    // Member Functions
    void accept()
    {
        printf("Enter the hrs - ");
        scanf("%d", &hr);
        printf("Enter the mins - ");
        scanf("%d", &min);
    }

    void display()
    {
        printf("Time = %d : %d\n", hr, min);
    }
};

int main()
{
    // bydefault the memebers of the structure are public.

    struct Time t1; // object of structure
    // To access members of the structure use the object

    t1.hr;  // NOT OK
    t1.min; // NOT OK
    // we cannot access private members outside the structure

    // we can access public members outside the structure
    t1.accept();  // OK
    t1.display(); // OK

    return 0;
}