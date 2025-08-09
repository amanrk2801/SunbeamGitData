#include <iostream>
namespace NA
{
    int n1 = 10;
    int n2 = 20;
}

namespace NB
{
    int n2 = 200;
    int n3 = 30;
}
using namespace NA;
int main()
{
    printf("Value of NA::n1 = %d\n", n1);
    printf("Value of NA::n2 = %d\n", n2);
    using namespace NB;
    printf("Value of NB::n2 = %d\n", NB::n2);
    printf("Value of NB::n3 = %d\n", n3);
    return 0;
}