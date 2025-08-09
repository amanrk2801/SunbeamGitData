#include "student.h"

int menu()
{
    int choice;
    cout << "********************************************" << endl;
    cout << "0. EXIT" << endl;
    cout << "1. Add Course" << endl;
    cout << "2. Add Student" << endl;
    cout << "3. Display All Courses" << endl;
    cout << "4. Display All Students" << endl;
    cout << "5. Purchase a course" << endl;
    cout << "6. Display course taken by a specific student" << endl;
    cout << "Enter your choice - ";
    cin >> choice;
    cout << "********************************************" << endl;

    return choice;
}

void displayAllCourses(vector<Course *> &courses)
{
    for (int i = 0; i < courses.size(); i++)
        courses[i]->displayCourse();
}

void purchaseCourse(vector<Course *> &coursesOffered, vector<Student *> &studentList)
{
    int rollno;
    cout << "Enter rollno of the student who want's the course - ";
    cin >> rollno;
    Student *sptr = NULL;
    // for loop for searching the given student
    for (int i = 0; i < studentList.size(); i++)
    {
        if (rollno == studentList[i]->getRollNo())
        {
            sptr = studentList[i];
            break;
        }
    }
    if (sptr != NULL)
    {
        // once student is found display him the courses to purchase
        displayAllCourses(coursesOffered);
        int cid;
        cout << "Enter the course id to purhcase the course - ";
        cin >> cid;
        for (int i = 0; i < coursesOffered.size(); i++)
        {
            if (cid == coursesOffered[i]->getCid())
            {
                sptr->getCoursesTaken().push_back(coursesOffered[i]);
                // OR
                // sptr->addCourseinCourseTaken(coursesOffered[i]);
                break;
            }
        }
    }
    else
        cout << "Student not found." << endl;
}

void displayCoursesTakenForGivenStudent(vector<Student *> &studentList)
{
    int rollno;
    cout << "Enter your rollno to display purchased courses - ";
    cin >> rollno;
    for (int i = 0; i < studentList.size(); i++)
    {
        if (rollno == studentList[i]->getRollNo())
        {
            studentList[i]->displayStudent();
            cout << "Courses Taken ->" << endl;
            displayAllCourses(studentList[i]->getCoursesTaken());
            break;
        }
    }
}

void addDummyCourses(vector<Course *> &coursesOffered)
{
    coursesOffered.push_back(new Course(1, "CPP", 5000));
    coursesOffered.push_back(new Course(2, "JAVA", 7000));
    coursesOffered.push_back(new Course(3, "PYTHON", 7000));
    coursesOffered.push_back(new Course(4, "DSA", 6000));
}

void addDummyStudents(vector<Student *> &studentList)
{
    studentList.push_back(new Student(1, "Anil"));
    studentList.push_back(new Student(2, "Mukesh"));
    studentList.push_back(new Student(3, "Ramesh"));
    studentList.push_back(new Student(4, "Suresh"));
    studentList.push_back(new Student(5, "Ram"));
    studentList.push_back(new Student(6, "Sham"));
}

int main()
{
    int n1 = 10;
    vector<Course *> coursesOffered;
    vector<Student *> studentList;
    addDummyCourses(coursesOffered);
    addDummyStudents(studentList);

    int choice;
    while ((choice = menu()) != 0)
    {
        switch (choice)
        {
        case 1:
        {
            // Adding the course in the coursesOffered
            Course *ptr = new Course();
            ptr->acceptCourse();
            coursesOffered.push_back(ptr);
        }
        break;
        case 2:
        {
            // Adding the student in the studentList
            Student *ptr = new Student();
            ptr->acceptStudent();
            studentList.push_back(ptr);
        }
        break;
        case 3:
            displayAllCourses(coursesOffered);
            break;
        case 4:
            for (int i = 0; i < studentList.size(); i++)
                studentList[i]->displayStudent();
            break;
        case 5:
            purchaseCourse(coursesOffered, studentList);
            break;
        case 6:
            displayCoursesTakenForGivenStudent(studentList);
            break;
        default:
            cout << "Wrong choice..." << endl;
            break;
        }
    }
    return 0;
}
