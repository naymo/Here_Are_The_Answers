//Naymish Vaghela
//Programming Language Concepts
//Test 2

#include <iostream>
using namespace std;

enum DAYS {
    SUNDAY = 1,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
};

enum DIGITS { 
    ONE = 1,
    TWO,
    THREE,
    FOUR,
    FIVE
};

int main()
{
    cout<< (ONE + SUNDAY) << endl;
    cout<< (THREE ^ WEDNESDAY) << endl;
    cout<< (SATURDAY - FOUR) << endl; 
    cout<< (FRIDAY & (FRIDAY / ONE)) << endl; 
    cout<< (MONDAY / FOUR) << endl;
    cout<< (THURSDAY | FIVE) << endl;  
    cout<< (TWO * TUESDAY) << endl; 
    cout<< (FRIDAY >> SATURDAY) << endl;   
    cout<< (FIVE % TWO) << endl;
    cout<< (SATURDAY << SATURDAY) << endl;
}
