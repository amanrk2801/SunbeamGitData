#ifndef employee_h
#define employee_h
#include <iostream>
using namespace std;
class Employee
{
    int id;
    string name;
    double salary;

public:
    Employee();
    Employee(int id, string name, double salary);
    void accept();
    void display();
};

#endif