#ifndef course_h
#define course_h
#include <iostream>
using namespace std;
class Course
{
    int cid;
    string courseName;
    double fees;

public:
    Course();
    Course(int cid, string courseName, double fees);
    void acceptCourse();
    void displayCourse();
    int getCid();
};
#endif