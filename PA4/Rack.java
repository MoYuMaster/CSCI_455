// Name: 
// USC NetID: 
// CS 455 PA4
// Fall 2019

import java.util.*;

/**
   A Rack of Scrabble tiles
 */

public class Rack {

   private String unique;
   private  int[] mult;

   public Rack( String s ){

      unique = "";
      getUnique(s);
   }

   /** Get unique letters from given String s
    *  Compute each letters multiplicity and store
    *  And store the multiplicity in list
    * @param s
    */
   private void getUnique(String s) {

      char[] str = s.toCharArray();
      Arrays.sort(str);

      //* Use map to compute the multiplicity of letter
      TreeMap<Character,Integer> map = new TreeMap<>();

      for (char character: str ){
         Integer num = map.get(character);
         map.put(character, num == null?1:num+1);
      }

      //* Use list to store and return character's value
      Iterator<Map.Entry<Character,Integer>> iterator = map.entrySet().iterator();
      mult = new int[map.size()];
      for( int i = 0 ; i < mult.length ; i++ ){

         Map.Entry<Character,Integer> entry = iterator.next();
         mult[i] = entry.getValue();
         unique += Character.toString(entry.getKey());
      }

   }

   /** Get rack's subsets
    *
    * @return a list of all possible subsets
    */
   public ArrayList<String> getAllSubsets(){
      //* defensive copy
      return new ArrayList<>(allSubsets(unique,mult,0));
   }


   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset.  Unlike the multiset in the parameters,
      each subset is represented as a String that can have repeated characters in it.
      @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();

      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }

      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);

      // prepend all possible numbers of the first char (i.e., the one at position k)
      // to the front of each string in restCombos.  Suppose that char is 'a'...

      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }

      return allCombos;
   }


}
