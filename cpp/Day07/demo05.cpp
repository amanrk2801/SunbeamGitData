#include <iostream>
using namespace std;
class Person
{
private:
    string name;

public:
    Person()
    {
        cout << "Person()" << endl;
    }
    Person(string name)
    {
        cout << "Person(string)" << endl;
        this->name = name;
    }

    virtual void accept()
    {
        cout << "Enter name - ";
        cin >> name;
    }
    virtual void display()
    {
        cout << "Name - " << name << endl;
    }
};

class Employee : public Person
{
private:
    int id;
    double salary;

public:
    Employee()
    {
        cout << "Empoyee()" << endl;
    }

    Employee(int id, string name, double salary) : Person(name)
    {
        cout << "Empoyee(int,string,double)" << endl;
        this->id = id;
        this->salary = salary;
    }

    // function overriding
    void accept()
    {
        cout << "Enter the id - ";
        cin >> id;

        Person::accept();
        // reusing the base class function by unhiding its implementation

        cout << "Enter the salary - ";
        cin >> salary;
    }

    void display()
    {
        cout << "Id - " << id << endl;
        Person::display();
        cout << "Salary - " << salary << endl;
    }
};

class Student : public Person
{
private:
    int rollno;
    double marks;

public:
    Student()
    {
        cout << "Studnet()" << endl;
    }

    Student(int rollno, string name, double marks) : Person(name)
    {
        cout << "Student(int,string,double)" << endl;
        this->rollno = rollno;
        this->marks = marks;
    }

    void accept()
    {
        cout << "Enter the rollno - ";
        cin >> rollno;
        Person::accept();
        cout << "Enter the marks - ";
        cin >> marks;
    }

    void display()
    {
        cout << "Rollno - " << rollno << endl;
        Person::display();
        cout << "Marks - " << marks << endl;
    }
};

int menu()
{
    int choice;
    cout << "***********************" << endl;
    cout << "0. EXIT" << endl;
    cout << "1. Add Employee" << endl;
    cout << "2. Add Student" << endl;
    cout << "3. Display All" << endl;
    cout << "4. Display All Employees" << endl;
    cout << "5. Display All Students" << endl;
    cout << "Enter your choice - ";
    cin >> choice;
    cout << "***********************" << endl;

    return choice;
}

int main()
{
    int choice;
    int index = 0;
    // Array of pointers to Person objects to store up to 5 Person (Employee or Student) objects
    Person *person_list[5];
    while ((choice = menu()) != 0)
    {
        switch (choice)
        {
        case 1:
            if (index < 5)
            {
                person_list[index] = new Employee(); // upcasting
                person_list[index]->accept();
                index++;
            }
            else
            {
                cout << "Array is full" << endl;
            }
            break;
        case 2:
            if (index < 5)
            {
                // Assign a new Student object to the person_list at the given index
                person_list[index] = new Student(); // upcasting

                // Call the accept() method on the object at the current index of person_list
                person_list[index]->accept();

                // Increment the index to point to the next position in the person_list
                index++;
            }

            break;
        case 3:
            for (int i = 0; i < index; i++)
                person_list[i]->display();
            break;

        case 4:
            for (int i = 0; i < index; i++)
            {
                // Check if the type of the object pointed to by person_list[i] is Employee
                if (typeid(*person_list[i]) == typeid(Employee))
                    person_list[i]->display();
            }
            break;

        case 5:
            for (int i = 0; i < index; i++)
            {
                if (typeid(*person_list[i]) == typeid(Student))
                    person_list[i]->display();
            }
            break;
        default:
            cout << "Wrong choice..." << endl;
            break;
        }
    }

    return 0;
}
