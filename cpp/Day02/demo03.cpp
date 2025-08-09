#include <iostream>

struct Time
{
    // Data
    int hr;
    int min;

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
    struct Time t1; // variable of the structure
    // variable of a structure is called as object
    // accept(&t1);
    // display(&t1);

    t1.accept();
    t1.display();
    return 0;
}