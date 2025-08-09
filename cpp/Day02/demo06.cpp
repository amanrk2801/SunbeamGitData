#include <iostream>
// function overloading
// Defining multiple functions with same name but different signature
// function overloading is an example of compile time polymorphism

void add(int n1, int n2) // no of parameters - 2
{
    printf("Addition = %d\n", (n1 + n2));
}

void add(int n1, int n2, int n3) // no of parameters - 3
{
    printf("Addition = %d\n", (n1 + n2 + n3));
}

void square(int n) // type of parameter - int
{
    printf("Square = %d\n", (n * n));
}

void square(double n) // type of parameter - double
{
    printf("Square = %lf\n", (n * n));
}

void division(int n, double d) // order of paramater (int,double)
{
    printf("Division = %lf\n", (n / d));
}

void division(double n, int d) // order of paramater (double,int)
{
    printf("Division = %lf\n", (n / d));
}

int main()
{
    add(10, 20);
    add(10, 20, 30);
    square(5);
    square(5.5);
    division(10, 2.5);
    division(10.5, 2);
    return 0;
}