#include "student.h"

Student::Student()
{
}
Student::Student(int rollno, string name)
{
    this->rollno = rollno;
    this->name = name;
}
void Student::acceptStudent()
{
    cout << "Enter the rollno - ";
    cin >> rollno;
    cout << "Enter the name - ";
    cin >> name;
}

void Student::displayStudent()
{
    cout << "Rollno - " << rollno << endl;
    cout << "Name - " << name << endl;
    cout << "---------------------------------" << endl;
}

int Student::getRollNo()
{
    return rollno;
}

vector<Course *> &Student::getCoursesTaken()
{
    return courseTaken;
}

void Student::addCourseinCourseTaken(Course *cptr)
{
    courseTaken.push_back(cptr);
}
