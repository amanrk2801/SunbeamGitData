#include <iostream>
#include <fstream>
using namespace std;

// void write()
// {
//     ofstream fout("file2.txt", ios::app);
//     fout << "Hello" << endl;
//     fout.close();
// }

void read()
{
    ifstream fin("file1.txt");

    string name;
    while (getline(fin, name))
    {
        cout << name << endl;
    }

    fin.close();
}

int main()
{
    // write();
    read();
    return 0;
}