#include <iostream>
using namespace std;

class Circle
{
private:
    double radius;
    static double PI;

public:
    Circle()
    {
    }
    Circle(double radius)
    {
        this->radius = radius;
    }

    void calculateArea()
    {
        double area = PI * radius * radius;
        cout << "Area of Circle = " << area << endl;
    }

    // static member functions do not get this pointer
    static void setPI(double PI)
    {
        Circle::PI = PI;
    }

    static double getPI()
    {
        return PI;
    }

    static void calculateTotalAreaOfAllCircles(Circle arr[5])
    {
        // logic to add the areas.
    }
};

double Circle::PI = 3.14;

int main()
{

    Circle arr[5];
    Circle::calculateTotalAreaOfAllCircles(arr);

    Circle c1(5);
    c1.calculateArea();

    Circle c2(7);
    c2.calculateArea();

    Circle c3(9);
    c3.calculateArea();

    // Circle::setPI(3.15);
    cout << "PI = " << Circle::getPI() << endl;
    // TO-DO
    // check the size of an object before making the PI as static
}