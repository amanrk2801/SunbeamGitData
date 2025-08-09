#include <iostream>

class Time
{
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

class Test
{
};

int main()
{
    Time t1; // variable of a class
    // Variable of a class is called as object

    // By default members of the class are private
    // t1.accept();
    // t1.display();

    printf("Size of Test = %d", sizeof(Test));
    // printf("Address of t1 = %d", &t1);
    return 0;
}