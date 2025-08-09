#include <iostream>
using namespace std;

class Employee {
private:
    int id;
    double salary;

public:
    Employee()
    {
        // Default constructor
    }
    
    Employee(int id, double salary)
    {
        this->id = id;
        this->salary = salary;
    }
    
    virtual void accept()
    {
        cout << "Enter id - ";
        cin >> id;
        cout << "Enter salary - ";
        cin >> salary;
    }
    
    virtual void display()
    {
        cout << "Id - " << id << endl;
        cout << "Salary - " << salary << endl;
    }
    
    // Virtual destructor for proper cleanup when deleting derived classes
    virtual ~Employee() {}
};

class Manager : virtual public Employee {
private:
    double bonus;

protected:
    void acceptManager()
    {
        cout << "Enter bonus - ";
        cin >> bonus;
    }
    
    void displayManager()
    {
        cout << "Bonus - " << bonus << endl;
    }

public:
    Manager()
    {
        // Default constructor
    }
    
    Manager(int id, double salary, double bonus) : Employee(id, salary)
    {
        this->bonus = bonus;
    }
    
    void accept() override
    {
        Employee::accept();
        acceptManager();
    }
    
    void display() override
    {
        Employee::display();
        displayManager();
    }
    
    // Add setter for bonus
    void setBonus(double b)
    {
        bonus = b;
    }
};

class Salesman : virtual public Employee {
private:
    double commission;

protected:
    void acceptSalesman()
    {
        cout << "Enter commission - ";
        cin >> commission;
    }
    
    void displaySalesman()
    {
        cout << "Commission - " << commission << endl;
    }

public:
    Salesman()
    {
        // Default constructor
    }
    
    Salesman(int id, double salary, double commission) : Employee(id, salary)
    {
        this->commission = commission;
    }
    
    void accept() override
    {
        Employee::accept();
        acceptSalesman();
    }
    
    void display() override
    {
        Employee::display();
        displaySalesman();
    }
    
    void setCommission(double commission)
    {
        this->commission = commission;
    }
};

class Salesmanager : public Manager, public Salesman {
public:
    Salesmanager()
    {
        // Default constructor
    }
    
    Salesmanager(int id, double salary, double bonus, double commission) : Employee(id, salary)
    {
        // Use the mutators of manager and salesman to add bonus and commission
        Manager::setBonus(bonus);
        Salesman::setCommission(commission);
    }
    
    void accept() override
    {
        // Don't call Manager::accept() and Salesman::accept() directly
        // as that would call Employee::accept() twice
        Employee::accept();
        Manager::acceptManager();
        Salesman::acceptSalesman();
    }
    
    void display() override
    {
        Employee::display();
        Manager::displayManager();
        Salesman::displaySalesman();
    }
};

int main() {
    // Create and input data for Manager
    cout << "=== Enter Manager Data ===" << endl;
    Manager m;
    m.accept();
    
    // Create and input data for Salesman
    cout << "\n=== Enter Salesman Data ===" << endl;
    Salesman sm;
    sm.accept();
    
    // Create a Salesmanager using polymorphism through base class pointer
    cout << "\n=== Enter Salesmanager Data ===" << endl;
    Employee *eptr = new Salesmanager();
    eptr->accept();
    
    // Display results
    cout << "\n=== Manager Details ===" << endl;
    m.display();
    
    cout << "\n=== Salesman Details ===" << endl;
    sm.display();
    
    cout << "\n=== Salesmanager Details ===" << endl;
    eptr->display();
    
    // Clean up dynamically allocated memory
    delete eptr;
    
    return 0;
}