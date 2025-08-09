#ifndef student_h
#define student_h
#include <vector>
#include "course.h"
class Student
{
    int rollno;
    string name;
    vector<Course *> courseTaken;

public:
    Student();
    Student(int rollno, string name);
    void acceptStudent();
    void displayStudent();
    int getRollNo();
    vector<Course *> &getCoursesTaken();
    void addCourseinCourseTaken(Course *cptr);
};
#endif