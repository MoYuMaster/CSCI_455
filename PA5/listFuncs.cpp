// Name:Yaochun Li
// USC NetID: yaochunl
// CSCI 455 PA5
// Fall 2019


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
   key = theKey;
   value = theValue;
   next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
   key = theKey;
   value = theValue;
   next = n;
}




//*************************************************************************
// put the function definitions for your list functions below


/**
 * Insert a new node in front of the list.
 * @param list
 * @param key string
 * @param value related to the key
 */
void insertInfront(ListType &list , const std::string key , int value ){

    list = new Node(key,value,list);
}


/**
 * append a node at the end of the list
 * @param list
 * @param key string
 * @param value related to the key .
*/
void appendNode(ListType &list, const std::string key , int value){

    ListType temp = list;
    //* If the list is empty *//
    if( temp == nullptr ){
        insertInfront(list,key,value);
        return;
    }

    //* else use while loop to iterate into the end of the list *//
    while(temp->next != nullptr ){
        temp = temp->next;
    }
    ListType newNode = new Node(key,value);
    temp->next = newNode;

}


/**
 * Search for a specific target node.
 * @param list
 * @param key target string
 * @return nullptr
**/
int *lookUpNode(ListType & list , const std::string target){

    ListType temp = list ;
    while( temp != nullptr ){
        if( temp->key == target ){
            return &(temp->value);
        }
        temp = temp -> next;
    }
    return nullptr;
}


/**
 *  Remove a specific target node .
 * @param list
 * @param key target string
 * @return true if remove successful , else return false .
**/
bool removeNode(ListType &list, const std::string target ){

    ListType temp = list ;
    //* If pointer value is target , delete the entry and return true *//
    if( temp->key == target ){
        list = list->next;
        delete temp;
        return true;
    }

    //* else using while loop search the whole list *//
    while( temp->next != nullptr ){
        if( temp->next->key == target ){
            ListType newNode = temp->next->next;
            delete temp->next;
            temp->next = newNode;
            return true;
        }
        temp = temp->next;
    }
    return false;

}


/**
 *  Print the whole list .
 * @param list
**/
void printList(ListType &list){

    ListType temp = list;
    while(temp != nullptr ){
        cout<< temp->key << " " << temp->value << endl;
        temp = temp->next;
    }
}


/**
 *  Return the size of the list .
 * @param list
 * @return  the size of the list .
 */
int listSize(ListType &list){

    ListType temp = list ;
    int size = 0;
    while( temp != nullptr ){
        size++;
        temp = temp ->next;
    }
    return size;

}
