// Name:    Yaochun Li
// USC NetID:   yaochunl
// CSCI 455 PA5
// Fall 2019

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 *
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>


using namespace std;

void readData(Table *grades);
void myInsert(Table *grades,const string &key , int score);
void change(Table *grades, const string &key, int score);
void lookUp(Table *grades, const string &key);
void myRemove(Table *grades, const string &key);
void help();

int main(int argc, char * argv[]) {

   // gets the hash table size from the command line

   int hashSize = Table::HASH_SIZE;

   Table * grades;  // Table is dynamically allocated below, so we can call
   // different constructors depending on input from the user.

   if (argc > 1) {
      hashSize = atoi(argv[1]);  // atoi converts c-string to int

      if (hashSize < 1) {
         cout << "Command line argument (hashSize) must be a positive number"
              << endl;
         return 1;
      }

      grades = new Table(hashSize);

   }
   else {   // no command line args given -- use default table size
      grades = new Table();
   }


   grades->hashStats(cout);

   // add more code here
   // Reminder: use -> when calling Table methods, since grades is type Table*
   readData(grades);


   return 0;
}

void readData(Table*grades){

    string cmd , name ;
    int score ;

    cout<< "cmd> ";

    //*     doing specific operations based on the command      *//
    while(cin>> cmd){

            if(cmd == "insert"){
                cin>>name>>score;
                myInsert(grades,name,score);
            }
            else if (cmd == "change"){
                cin>>name>>score;
                change(grades,name,score);
            }
            else if (cmd == "lookup"){
                cin>>name;
                lookUp(grades,name);
            }
            else if (cmd == "remove"){
                cin>>name;
                myRemove(grades,name);
            }
            else if (cmd == "print"){
                grades->printAll();
            }
            else if (cmd == "size"){
                cout<< grades->numEntries()<<endl;
            }
            else if (cmd == "stats"){
                grades->hashStats(cout);
            }
            else if ( cmd == "help"){
                help();
            }
            else if ( cmd == "quit" ){
                return;
            }
            else{
                cout<< "ERROR: invalid command"<<endl;
                help();
            }
            cout<<"cmd> ";

    }
}


/**
 * Insert entry and prompt if error exist .
 * @param grades
 * @param key
 * @param score
 */
void myInsert(Table*grades,const string&key , int score ){

    bool insertDone = grades->insert(key,score);
    if(!insertDone){
        cout<< "This name has already existed in the grade table."<<endl;
    }
}


/**
 * Change the entry based on the key and prompt if error exist .
 * @param grades
 * @param key
 * @param score
 */
void change(Table*grades, const string&key, int score ){

    if(grades->lookup(key) == NULL ){
        cout<< "This name is not presented in the grade table."<<endl;
    }
    else{
        int *value = grades ->lookup(key);
        *value = score;
    }
}


/**
 *  Look up entry based on key and prompt if error exist .
 * @param grades
 * @param key
 */
void lookUp(Table*grades, const string&key){
    if(grades->lookup(key) == NULL){
        cout << "This name is not presented in the grade table."<<endl;
    }
    else{
        int *value = grades->lookup(key);
        cout<< *value<<endl;
    }
}


/**
 *  Remove the key and  prompt if error exist .
 * @param grades
 * @param key string
 */
void myRemove(Table*grades, const string&key){
    bool removeDone = grades->remove(key);
    if(!removeDone){
        cout<< "This name is not presented in the grade table."<<endl;
    }
}


/**
 *  Help method to help the user learn about the command
 */
void help(){

    cout<< "Command Instructions : " << endl;
    cout<< "insert name score" << endl;
    cout<< "    Insert this name and score in the grade table. If this name was already present, print a"<<endl;
    cout<< "    message to that effect, and don't do the insert." << endl;
    cout<< "change name newscore"<<endl;
    cout<< "    Change the score for name. Print an appropriate message if this name isn't present."<<endl;
    cout<< "lookup name"<<endl;
    cout<< "    Lookup the name, and print out his or her score, or a message indicating that student is"<<endl;
    cout<< "    not in the table."<<endl;
    cout<< "remove name"<<endl;
    cout<< "    Remove this student. If this student wasn't in the grade table, print a message to that"<<endl;
    cout<< "    effect."<<endl;
    cout<< "print"<<endl;
    cout<< "    Prints out all names and scores in the table."<<endl;
    cout<< "size"<<endl;
    cout<< "    Prints out the number of entries in the table."<<endl;
    cout<< "stats"<<endl;
    cout<< "    Prints out statistics about the hash table at this point. (Calls hashStats() method)"<<endl;
    cout<< "help"<<endl;
    cout<< "    Prints out a brief command summary."<<endl;
    cout<< "quit"<<endl;
    cout<< "    Exits the program."<<endl;

}

