#include <iostream>
namespace NA
{
    int n1 = 10;
    int n2 = 20;
    namespace NB
    {
        int n2 = 200;
        int n3 = 30;
    }
}

using namespace NA::NB;
int main()
{
    printf("NA::n1 = %d\n", NA::n1);
    printf("NA::n2 = %d\n", NA::n2);
    printf("NB::n2 = %d\n", n2);
    printf("NB::n3 = %d\n", n3);
    return 0;
}