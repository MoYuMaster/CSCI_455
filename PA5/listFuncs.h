// Name: Yaochun Li
// USC NetID: yaochunl
// CSCI 455 PA5
// Fall 2019


//*************************************************************************
// Node class definition
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.

// Note2: it's good practice to not put "using" statement in *header* files.  Thus
// here, things from std libary appear as, for example, std::string

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H


struct Node {
   std::string key;
   int value;

   Node *next;

   Node(const std::string &theKey, int theValue);

   Node(const std::string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

//*   All the method which need to be construct     *//
//*  Insert a new node in front of the list *//
void insertInfront(ListType &list , std::string key , int value );
//*  append a node at the end of the list *//
void appendNode(ListType &list, std::string key , int value);
//*  search for a specific target node *//
int *lookUpNode(ListType &list, std::string target );
//*  remove a specific target node *//
bool removeNode(ListType &list, std::string target );
//*  print the whole list *//
void printList(ListType &list);
//*  return the size of the list *//
int listSize(ListType &list);

// keep the following line at the end of the file
#endif
