// Name: Yaochun Li
// USC NetID: yaochunl
// CS 455 PA4
// Fall 2019

import java.io.FileNotFoundException;
import java.util.*;

/**
 * This contains the main method. This class will have a main that's responsible for processing the command-line
 * argument, and handling any error processing. It will probably also have the main command loop. Most of the other
 * functionality will be delegated to other object(s) created in main and their methods.
 *
 */

public class WordFinder {

    /**
     * The main method to process the wordFinder program .
     * if file can not found , remind the user and exit .
     * @param args
     */
    public static void main(String[] args) {

        String fileName = "sowpods.txt";

        if (args.length > 0) {
            fileName = args[0];
        }
        try {

            AnagramDictionary anagramDictionary = new AnagramDictionary(fileName);
            wordFinder( anagramDictionary );

        } catch(FileNotFoundException e) {

            System.out.println("Could not open input file: " + fileName);
        }

    }


    /**
     * Find and print all the words can be formed from the rack .
     * The result display in decreasing order based on scores .
     * If words' scores are same , then display in alphabetical order .
     * @param anagramDictionary : dictionary of anagrams
     */
    private static void wordFinder (AnagramDictionary anagramDictionary) {

        System.out.println("Type . to quit.");
        System.out.print("Rack? ");
        /*      Create a scanner    */
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {

            /*      Exit if the user enter '.'     */
            String input = in.next();
            if( input.equals(".") ) System.exit(0);
            /*      Create rack base on input , create list of anagrams , list of racks' subsets    */
            Rack rack = new Rack(input);
            ArrayList<String> anagrams = new ArrayList<String>();
            ArrayList<String> subsets = rack.getAllSubsets();
            /*      Use getAnagramsOf method , add results in anagrams list     */
            for(String str : subsets) {
                anagrams.addAll( anagramDictionary.getAnagramsOf(str) );
            }
            /*      Use getEntry to get anagrams-score pairs        */
            ArrayList<Map.Entry<String, Integer>> entryArrayList = getEntry(anagrams);

            System.out.println("We can make " + entryArrayList.size() + " words from \"" + input + "\"");

            if( entryArrayList.size() != 0) {
                System.out.println("All of the words with their scores (sorted by score): ");
            }

            for (Map.Entry<String, Integer> currentWord : entryArrayList ) {
                System.out.println( currentWord.getValue() + ": " + currentWord.getKey() );
            }

            System.out.print("Rack? ");

        }
    }


    /**
     * Use treemap to store , which key represent word , value represent score .
     * Sort these entry in decreasing order based on their scores .
     * @param anagrams : A list of all anagrams
     * @return entryArrayList : a list of entrys which pairs anagrams with their score
     */
    private static ArrayList<Map.Entry<String,Integer>> getEntry(ArrayList<String> anagrams) {

        /*      Create treemap and scoretable    */
        TreeMap<String, Integer> anagramsMap = new TreeMap<String, Integer>();
        ScoreTable score = new ScoreTable();
        /*      Use for each loop store every anagrams , Use getScore method to get their scores   */
        for(String string : anagrams) {
            anagramsMap.put(string, score.getScore(string));
        }
        /*      Create a arraylist to store all the entrys      */
        ArrayList<Map.Entry<String, Integer>> entryArrayList = new ArrayList<>(anagramsMap.entrySet());
        /*      Sort the arraylist with our own comparator      */
        entryArrayList.sort(new ScoreComparator());

        return entryArrayList;

    }
}


/**
 *  Sort entryArrayList in decreasing order based on their scores.
 */
class ScoreComparator implements Comparator<Map.Entry<String, Integer>> {
    public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b){
        /*      value represent the word's score    */
        return b.getValue() - a.getValue();
    }
}