#include <iostream>
#include <map>
using namespace std;

int main()
{
    map<int, string> m1;
    m1[128] = "Anil";
    m1[57] = "Mukesh";
    m1[245] = "Ramesh";
    m1[145] = "Ramesh";
    m1[57] = "Suresh";

    for (map<int, string>::iterator itr = m1.begin(); itr != m1.end(); itr++)
    {
        cout << itr->first << " - " << itr->second << endl;
    }

    return 0;
}
