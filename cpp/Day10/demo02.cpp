#include <iostream>
#include <fstream>
#include <sstream>
using namespace std;
class Employee
{
    int id;
    string name;
    double salary;

public:
    Employee()
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
        cout << "Enter the id - ";
        cin >> id;
        cout << "Enter the name - ";
        cin >> name;
        cout << "Enter the salary - ";
        cin >> salary;
    }

    void display()
    {
        cout << "Id -" << id << endl;
        cout << "Name -" << name << endl;
        cout << "Salary -" << salary << endl;
    }

    int getId()
    {
        return id;
    }
    string getName()
    {
        return name;
    }
    double getSalary()
    {
        return salary;
    }
};

void writeEmployee(Employee e)
{
    ofstream fout("emp.txt", ios::app);
    fout << e.getId() << "," << e.getName() << "," << e.getSalary() << endl;
    fout.close();
}

void readEmployee()
{
    ifstream fin("emp.txt");
    // convert the string data to the employee type of data
    string data;
    while (getline(fin, data))
    {
        string id, name, salary;
        stringstream ss(data);
        getline(ss, id, ',');
        getline(ss, name, ',');
        getline(ss, salary, ',');
        Employee e(stoi(id), name, stod(salary));
        e.display();
    }
    fin.close();
}

int main()
{
    // Employee e(2, "Mukesh", 20000);
    // Employee e;
    // e.accept();
    // writeEmployee(e);

    readEmployee();
    return 0;
}