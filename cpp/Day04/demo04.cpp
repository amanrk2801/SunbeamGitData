#include <iostream>
using namespace std;

class BankAccount
{
private:
    const int accno;
    string name;
    double balance;
    static int generate_accno;

public:
    BankAccount() : accno(++generate_accno)
    {
    }

    BankAccount(string name, double balance) : accno(++generate_accno)
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
};

int BankAccount::generate_accno = 1000;

int main()
{
    BankAccount b1("Anil", 10000);
    BankAccount b2;
    b2.acceptDetails();
    BankAccount b3("Ramesh", 30000);

    b1.displayAccountDetails();
    b2.displayAccountDetails();
    b3.displayAccountDetails();

    BankAccount b4;
    BankAccount b5;
    BankAccount b6;
    BankAccount b7;
    BankAccount b8;
    BankAccount b9;
    BankAccount b10;

    b10.displayAccountDetails();
    return 0;
}