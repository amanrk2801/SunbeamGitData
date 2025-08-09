#include <iostream>
using namespace std;

// abstract class
class Shape
{
public:
    // pure virtual functions
    virtual void acceptData() = 0;
    virtual void calculateArea() = 0;
};

class Circle : public Shape
{
    int radius;

public:
    void acceptData()
    {
        cout << "Enter the radius - ";
        cin >> radius;
    }
    void calculateArea()
    {
        cout << "Area of Circle - " << 3.14 * radius * radius << endl;
    }
};

class Square : public Shape
{
    int side;

public:
    void acceptData()
    {
        cout << "Enter the side - ";
        cin >> side;
    }
    void calculateArea()
    {
        cout << "Area of Square - " << side * side << endl;
    }
};

class Rectangle : public Shape
{
    int length;
    int breadth;

public:
    void acceptData()
    {
        cout << "Enter the length - ";
        cin >> length;
        cout << "Enter the breadth - ";
        cin >> breadth;
    }
    void calculateArea()
    {
        cout << "Area of Rectangle - " << length * breadth << endl;
    }
};

int menu()
{
    int choice;
    cout << "0. EXIT" << endl;
    cout << "1. Area of Rectangle" << endl;
    cout << "2. Area of Circle" << endl;
    cout << "3. Area of Square" << endl;
    cout << "Enter the chocie -  ";
    cin >> choice;
    return choice;
}

int main()
{
    int choice;
    Shape *sptr = NULL;
    while ((choice = menu()) != 0)
    {
        switch (choice)
        {
        case 1:
            sptr = new Rectangle();
            break;
        case 2:
            sptr = new Circle();
            break;
        case 3:
            sptr = new Square();
            break;
        default:
            cout << "Wrog chocie..." << endl;
            break;
        }
        if (sptr != NULL)
        {
            sptr->acceptData();
            sptr->calculateArea();
            delete sptr;
            sptr = NULL;
        }
    }

    return 0;
}