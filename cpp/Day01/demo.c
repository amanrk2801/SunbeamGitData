#include <stdio.h>

struct Time
{
    int hr;
    int min;
};

void acceptTime(struct Time *ptr)
{
    printf("Enter the hrs - ");
    scanf("%d", &ptr->hr);
    printf("Enter the mins - ");
    scanf("%d", &ptr->min);
}

void displayTime(struct Time *ptr)
{
    printf("Time = %d : %d \n", ptr->hr, ptr->min);
}

int main()
{
    // int in_hr;
    // int in_min;
    // int out_min;
    // int out_hr;

    // struct Time in_punch;
    // struct Time out_punch;
    struct Time t1;
    acceptTime(&t1);  // pass by address
    displayTime(&t1); // pass by address
    return 0;
}