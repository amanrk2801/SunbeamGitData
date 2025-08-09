#include <iostream>
using namespace std;
class Shape
{
public:
    virtual void accept() = 0;
    virtual void calculate() = 0;
    static Shape *shapeFactory(int choice);
};

class Circle : public Shape
{
    int radius;

public:
    void accept()
    {
        cout << "Enter radius" << endl;
        cin >> radius;
    }
    void calculate()
    {
        cout << "Area of Circle - " << 3.14 * radius * radius << endl;
    }
};

class Rectangle : public Shape
{
    int length;
    int breadth;

public:
    void accept()
    {
        cout << "Enter length" << endl;
        cin >> length;
        cout << "Enter breadth" << endl;
        cin >> breadth;
    }
    void calculate()
    {
        cout << "Area of Rectangle - " << length * breadth << endl;
    }
};

class Square : public Shape
{
    int side;

public:
    void accept()
    {
        cout << "Enter side" << endl;
        cin >> side;
    }
    void calculate()
    {
        cout << "Area of Square - " << side * side << endl;
    }
};

int menu()
{
    int choice;
    cout << "0. EXIT" << endl;
    cout << "1. Area of Circle" << endl;
    cout << "2. Area of Rectangle" << endl;
    cout << "3. Area of Square" << endl;
    cout << "Enter the choice - ";
    cin >> choice;
    return choice;
}

Shape *Shape::shapeFactory(int choice)
{
    switch (choice)
    {
    case 1:
        return new Circle();
    case 2:
        return new Rectangle();
    case 3:
        return new Square();
    }

    return NULL;
}

int main()
{
    int choice;
    Shape *shape = NULL;
    while ((choice = menu()) != 0)
    {
        switch (choice)
        {
        case 1:
        case 2:
        case 3:
            shape = Shape::shapeFactory(choice);
            break;
        default:
            cout << "Wrong choice..." << endl;
            break;
        }
        if (shape != NULL)
        {
            shape->accept();
            shape->calculate();
            delete shape;
            shape = NULL;
        }
    }
    return 0;
}