// Name: Yaochun Li
// USC NetID: 8555684098
// CSCI455 PA2
// Fall 2019

import java.util.ArrayList;
import java.util.Random;

/*
  class SolitaireBoard
  The board for Bulgarian Solitaire.  You can change what the total 
  number of cards is for the game by changing NUM_FINAL_PILES, below.  
  Don't change CARD_TOTAL directly, because there are only some values
  for CARD_TOTAL that result in a game that terminates.  (See comments 
  below next to named constant declarations for more details on this.)
*/


public class SolitaireBoard {

   public static final int NUM_FINAL_PILES = 9;
   // number of piles in a final configuration
   // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)

   public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;

   private static final int ARRAY_SIZE = 2 * CARD_TOTAL;
   // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
   // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
   // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

   // Note to students: you may not use an ArrayList -- see assgt
   // description for details.


   /**
      Representation invariant:
       CARD_TOTAL = the sum of numbers in each piles;
       Every number in piles must be none-negative integer;
       1 <= pilesSize <= CARD_TOTAL;
   */

   private int pilesSize;
   private int[] cards;
   private Random random;

   // <add instance variables here>


   /**
      Creates a solitaire board with the configuration specified in piles.
      piles has the number of cards in the first pile, then the number of
      cards in the second pile, etc.
      PRE: piles contains a sequence of positive numbers that sum to
      SolitaireBoard.CARD_TOTAL
   */
   public SolitaireBoard(ArrayList<Integer> piles) {
      /*  User create piles , add it to cards array  */
      cards = new int[ARRAY_SIZE];
      pilesSize = piles.size();

      for ( int i=0; i<pilesSize;i++ ){
         cards[i] = piles.get(i);
      }

      // sample assert statement (you will be adding more of these calls)
      // this statement stays at the end of the constructor.
      assert isValidSolitaireBoard();

   }


   /**
      Creates a solitaire board with a random initial configuration.
   */
   public SolitaireBoard() {

      /* SingleStep Piles */
      /* Since we didnt know exact how many piles are, Create a arraylist */

      random = new Random();
      ArrayList<Integer> result = new ArrayList<Integer>();
      int piles = 0 ;
      int sum = CARD_TOTAL;

      //* each piles minus 1 and add to a new pile *//
      while ( sum > 0 && piles < CARD_TOTAL ){

         int temp = random.nextInt(sum) + 1;
         result.add(temp);
         sum = sum - temp;
         piles ++;

      }

      if (sum > 0 ){
         result.add(sum);
      }
      //* move values from arraylist to array . *//
      cards = new int[ ARRAY_SIZE ];
      pilesSize = result.size();
      for(int i = 0; i < pilesSize; i++){
         cards[i] = result.get(i);
      }

      assert isValidSolitaireBoard();
   }


   /**
      Plays one round of Bulgarian solitaire.  Updates the configuration
      according to the rules of Bulgarian solitaire: Takes one card from each
      pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before,
      and the new pile will be at the end.
   */
   public void playRound() {

      /* Only use one variable , thus O(1) space complexity */
      /* Traverse one time , thus O(n) time complexity */

      int sum = 0;
      for (int i = 0; i < pilesSize ;i++ ){
         if (cards[i] != 0){
            cards[i]-- ;
            sum++ ;
         }
      }
      cards[ pilesSize++ ] = sum;

      assert isValidSolitaireBoard();
   }

   /**
      Returns true iff the current board is at the end of the game.  That is,
      there are NUM_FINAL_PILES piles that are of sizes
      1, 2, 3, . . . , NUM_FINAL_PILES,
      in any order.
   */

   public boolean isDone() {

      /* Create a piles array store cards , thus O(n) space complexity */
      /* Create one loop to check if is Done , thus O(n) time complexity */

      assert isValidSolitaireBoard();
      boolean[] piles = new boolean[ NUM_FINAL_PILES + 1 ];
      for (int i = 0 ; i < pilesSize ; i++ ){

         if (cards[i] == 0 ) continue;
         if (cards[i] > NUM_FINAL_PILES || piles[cards[i]] ) return false;
         piles[cards[i]] = true;

      }
      return true;  // dummy code to get stub to compile

   }


   /**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
   */
   public String configString() {

      String result = new String();
      for (int i : cards ){
         if (i != 0){
            result = result + i +" ";
         }
      }
      result = result.trim();

      assert isValidSolitaireBoard();
      return result;   // dummy code to get stub to compile

   }


   /**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
   */
   private boolean isValidSolitaireBoard() {

      /*  Precondition: piles contains a sequence of positive numbers that sum to SolitaireBoard.CARD_TOTAL */
      int sum = 0;
      for( int i : cards) {
         if( i > CARD_TOTAL ) {
            return false;
         }
         sum += i;
      }
      return sum == CARD_TOTAL ;  // dummy code to get stub to compile

   }
   // <add any additional private methods here>

}