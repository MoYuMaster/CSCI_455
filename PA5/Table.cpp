// Name: Yaochun Li
// USC NetID:yaochunl
// CSCI 455 PA5
// Fall 2019

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

//*  Constructor with and without parameter *//
Table::Table() {

    entryNum = 0 ;
    hashSize = HASH_SIZE;
    nlist = new ListType[hashSize];
    for(int i = 0 ; i< hashSize ; i++ ){
        nlist[i] = nullptr ;
    }
}


Table::Table(unsigned int hSize) {

    entryNum = 0 ;
    hashSize = hSize ;
    nlist = new ListType[hashSize];
    for( int i = 0 ; i < hashSize ; i++ ){
        nlist[i] = nullptr;
    }
}

//*  Use key to lookup *//
int * Table::lookup(const string &key) {

   return lookUpNode( nlist[hashCode(key)],key);
}

//*   Use key to remove *//
bool Table::remove(const string &key) {
   bool removed = removeNode(nlist[hashCode(key)],key);
   if(removed){
    entryNum--;
   }
   return removed;
}

//*   Insert data with key (String) , and value (int)   *//
bool Table::insert(const string &key, int value) {
    //*  If this data already exist *//
   if( lookUpNode( nlist[hashCode(key)],key) != nullptr ){
    return false;
   }

   insertInfront(nlist[hashCode(key)],key,value);
   entryNum ++ ;
   return true;

}
//*  Return the number of entries  *//
int Table::numEntries() const {

   return entryNum ;
}

//*   Print the list content    *//
void Table::printAll() const {

    for(int i = 0 ; i<hashSize ; i++){
        ListType list = nlist[i];
        printList(list);
    }

}

//*   Print hash statics    *//
void Table::hashStats(ostream &out) const {

    cout<< "Number of buckets: " << hashSize << endl;
    cout<< "Number of entries: " << entryNum << endl;

    int nonEmptyBuckets = 0 ; int longestChain = 0 ;
    //*  Using for loop to find to longest chain  *//
    for( int i = 0; i < hashSize; i++ ){
        if(nlist[i] != nullptr ){
            nonEmptyBuckets ++ ;
            longestChain = max(listSize(nlist[i]),longestChain);
        }
    }

    cout << "Number of non-empty buckets: " << nonEmptyBuckets << endl;
    cout << "Longest Chain: " << longestChain << endl;

}


// add definitions for your private methods here
