#include <iostream>
using namespace std;

class BankAccount
{
private:
    const int accno;
    string name;
    double balance;

public:
    BankAccount(int accno) : accno(accno)
    {
    }

    BankAccount(int accno, string name, double balance) : accno(accno)
    {
        this->name = name;
        this->balance = balance;
    }

    void acceptDetails()
    {
        cout << "Enter the name - ";
        cin >> name;
        cout << "Enter the initial balance - ";
        cin >> balance;
    }

    void displayAccountDetails() const
    {
        cout << "Accno - " << accno << endl;
        cout << "Name - " << name << endl;
        cout << "Balance - " << balance << endl;
    }

    void setName(string name)
    {
        this->name = name;
    }
    void setBalance(double balance)
    {
        this->balance = balance;
    }
    string getName() const
    {
        return name;
    }
    double getBalance() const
    {
        return balance;
    }
    int getAccno() const
    {
        return accno;
    }

    void withdraw(double amount)
    {
        this->balance = this->balance - amount;
    }

    void deposit(double amount)
    {
        this->balance = this->balance + amount;
    }
};

int main()
{
    BankAccount b1(1001);
    b1.acceptDetails();

    BankAccount b2(1002, "Anil", 10000);

    b1.displayAccountDetails();
    b2.displayAccountDetails();

    const BankAccount b3(1003, "Ramesh", 30000);
    b3.getName();
    return 0;
}