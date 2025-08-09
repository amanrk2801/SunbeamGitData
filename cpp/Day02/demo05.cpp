#include <iostream>

inline void add(int n1, int n2)
{
    int result = n1 + n2;
    printf("Addition = %d\n", result);
}

int main()
{
    add(10, 20);
    // int result = 10 + 20;
    // printf("Addition = %d\n", result);
    return 0;
}