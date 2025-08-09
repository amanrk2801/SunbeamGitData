#include <iostream>
using namespace std;

class Date
{
private:
    int day;
    int month;
    int year;

public:
    Date()
    {
        cout << "Date()" << endl;
    }

    Date(int day, int month, int year)
    {
        cout << "Date(int,int,int)" << endl;
        this->day = day;
        this->month = month;
        this->year = year;
    }
    void acceptDate()
    {
        cout << "Enter the day - ";
        cin >> day;
        cout << "Enter the month - ";
        cin >> month;
        cout << "Enter the year - ";
        cin >> year;
    }
    void displayDate()
    {
        cout << day << "/" << month << "/" << year << endl;
    }
};

// Employee has-a Date of Joining
class Employee
{
private:
    int id;
    string name;
    double salary;
    Date doj; // Association -> Composition

public:
    Employee()
    {
        cout << "Employee()" << endl;
    }

    Employee(int id, string name, double salary, int day, int month, int year) : doj(day, month, year)
    {
        cout << "Employee(int,string,double,int,int,int)" << endl;
        this->id = id;
        this->name = name;
        this->salary = salary;
    }

    void acceptEmployee()
    {
        cout << "Enter the id ";
        cin >> id;
        cout << "Enter the name ";
        cin >> name;
        cout << "Enter the salary ";
        cin >> salary;
        cout << "Enter the date of joining - " << endl;
        doj.acceptDate();
    }
    void displayEmployee()
    {
        cout << "Id - " << id << endl;
        cout << "Name - " << name << endl;
        cout << "Salary - " << salary << endl;
        cout << "Date of Joining - ";
        doj.displayDate();
    }
};

class Customer
{
    int cid;
    string name;
    Date *dob; // Association -> Aggregation

public:
    Customer()
    {
        cout << "Customer()" << endl;
        dob = NULL;
    }
    Customer(int cid, string name)
    {
        cout << "Customer(int,string)" << endl;
    }

    void acceptCustomer()
    {
        cout << "Enter the customer id - ";
        cin >> cid;
        cout << "Enter the name - ";
        cin >> name;
    }
    void addDob()
    {
        dob = new Date();
        cout << "Enter the date of birth - ";
        dob->acceptDate();
    }

    void displayCustomer()
    {
        cout << "Id - " << cid << endl;
        cout << "Name - " << name << endl;
        if (dob != NULL)
        {
            cout << "Date of Birth - ";
            dob->displayDate();
        }
    }

    ~Customer()
    {
        if (dob != NULL)
        {
            delete dob;
            dob = NULL;
        }
    }
};

class Product
{
    Date production_date;
    Date expiry_date;
    Date *order_date;
    Date *deliver_date;
};

int main()
{
    Customer c1;
    c1.acceptCustomer();
    c1.displayCustomer();

    Customer c2;
    c2.acceptCustomer();
    c2.addDob();
    c2.displayCustomer();
    return 0;
}

int main1()
{
    Employee e1;
    e1.acceptEmployee();

    Employee e2(2, "Anil", 20000, 2, 2, 2002);

    e1.displayEmployee();
    e2.displayEmployee();
    return 0;
}
