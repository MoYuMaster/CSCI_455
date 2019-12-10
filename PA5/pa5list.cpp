// Name: Yaochun Li
// USC NetID: yaochunl
// CS 455 PA5
// Fall 2019

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"


int main() {

    ListType test = nullptr;
    //*  Test insert *//
    cout<< "After inserting Mike , the list is " << endl;
    insertInfront(test, "Mike", 89);
    printList(test);
    cout << "-------------------" << endl;

    cout<< "After inserting Josh , the list is " << endl;
    insertInfront(test,"Josh",93);
    printList(test);
    cout << "-------------------" << endl;

    cout<< "After inserting Owen , the list is " << endl;
    insertInfront(test,"Owen",86);
    printList(test);
    cout << "-------------------" << endl;

    //*  Test append *//
    cout<< "After appending Mike , the list is " << endl;
    appendNode(test, "Eric", 99);
    printList(test);
    cout << "-------------------" << endl;

    //*  Test lookup *//
    cout<< "Looking for Josh ...  " << endl;
    int * x = lookUpNode(test, "Josh");
    cout << "His or her score is "<<*x << endl;
    cout << "-------------------" << endl;

    //*  Test remove *//
    cout<< "Remove Josh's score record ... " << endl;
    bool y = removeNode(test, "Josh");
    if( y ) {
        cout<< "Remove successfully ." << endl;
    } else{
        cout << "Error ."<<endl;
    }
    cout<< "After removing Josh , the list is " << endl;
    printList(test);


    return 0;

}
