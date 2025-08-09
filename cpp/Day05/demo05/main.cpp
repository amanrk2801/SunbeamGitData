#include "employee.h"

int main()
{
    Employee e1;
    e1.accept();
    e1.display();

    Employee e2(2, "Mukesh", 20000);
    e2.display();
    return 0;
}
