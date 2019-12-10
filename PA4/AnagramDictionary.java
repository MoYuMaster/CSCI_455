// Name: Yaochun Li
// USC NetID: yaochunl
// CS 455 PA4
// Fall 2019

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {

   private HashMap<String,ArrayList<String>> wordMap;

   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.
      PRE: The strings in the file are unique.
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {

      Scanner in = new Scanner(new File(fileName));
      /*    Use getWordMap method to get strings and their corresponding anagrams   */
      wordMap = getWordMap(in);

   }

   /**
    * Get a wordMap of anagrams of words in input file .
    * Key is the canonical form of strings , Value is a list of anagrams of the string .
    * @param in : Use scanner to input words
    * @return map1 : word map based on canon
    */
   private HashMap<String,ArrayList<String>> getWordMap(Scanner in){

      String str = "" , canonString = "" ;
      HashMap<String,ArrayList<String>> wordMap = new HashMap<String, ArrayList<String>>();

      while (in.hasNext()){

         str = in.next();
         canonString = getCanonOf(str);

         ArrayList<String> anagramsList = new ArrayList<String>();

         /*    if map didnt have this canonical version string , then add it into map  */
         if ( !wordMap.containsKey(canonString)){
            anagramsList.add(str);
            wordMap.put(canonString,anagramsList);
         }
         /*    if it already exist , then add its origin version into anagramsList     */
         else {
            anagramsList = wordMap.get(canonString);
            anagramsList.add(str);
            wordMap.put(canonString,anagramsList);
         }
      }
      return wordMap;

   }


   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String s) {

      String canon = getCanonOf(s);

      if ( wordMap.containsKey(canon) ) {
         /*    if this string has existed in map   */
         return new ArrayList<String>(wordMap.get(canon));
      }
      else return new ArrayList<String>();

   }

   /** Get canonical form from given string
    *  This canonical form will be a sorted version of the characters in the word.
    * @param s : Given string
    * @return Canonical form from given string .
    */
   private String getCanonOf(String s) {

      /*    sort the word in alphabetical order */
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      return String.valueOf(chars);
   }

}
