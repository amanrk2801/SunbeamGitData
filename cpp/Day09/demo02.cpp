#include <iostream>
#include <vector>
using namespace std;
class Employee
{
    int id;
    string name;
    double salary;

public:
    Employee() : Employee(0, "", 0.0)
    {
    }
    Employee(int id, string name, double salary)
    {
        this->id = id;
        this->name = name;
        this->salary = salary;
    }
    void accept()
    {
        cout << "Employee::accept()" << endl;
    }
    void display()
    {
        cout << "Id - " << id << endl;
        cout << "name - " << name << endl;
        cout << "salary - " << salary << endl;
    }
};
int main()
{
    vector<Employee *> emp_list;
    Employee *ptr;
    ptr = new Employee();
    // ptr->accept();
    emp_list.push_back(ptr);

    ptr = new Employee(1, "Anil", 10000);
    ptr->accept();
    emp_list.push_back(ptr);

    cout << "size =  " << emp_list.size() << endl;

    emp_list.at(0)->display();
    emp_list[1]->display();

    cout << "Progarm finished..." << endl;

    // delete ptr;
    // ptr = nullptr;

    for (int i = 0; i < emp_list.size(); i++)
    {
        delete emp_list[i];
        emp_list[i] = nullptr;
    }
    
    return 0;
}