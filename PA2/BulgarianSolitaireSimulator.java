// Name: Yaochun Li
// USC NetID: 8555684098
// CSCI455 PA2
// Fall 2019


import java.util.ArrayList;
import java.util.Scanner;

/**
   <add main program comment here>
*/

public class BulgarianSolitaireSimulator {

   public static void main(String[] args) {

      boolean singleStep = false;
      boolean userConfig = false;

      for ( int i = 0; i < args.length; i++) {
         if ( args[i].equals("-u") ) {
            userConfig = true;
         }
         else if (args[i].equals("-s")) {
            singleStep = true;
         }
      }

      // <add code here>

      Scanner in = new Scanner(System.in);
      ArrayList<Integer> result = new ArrayList<Integer>();
      //*  when only -u  *//
      if ( userConfig ){
         testUser(result,in,singleStep);
      }
      //*  when only -s  *//
      if (singleStep){
         testSingle(in,singleStep);
      }
      //*   when -u -s  *//
      if (!userConfig && !singleStep ){
         testSingle(in,singleStep);
      }
   }

   // <add private static methods here>

   private static boolean userHelper(ArrayList<Integer> result ,Scanner in){

      String intial = in.nextLine();
      int sum = 0;
      String s = "";
      for ( int i=0 ; i< intial.length(); i++ ){
         if ((intial.charAt(i) != ' ')&& intial.charAt(i) != '\t'&&(!Character.isDigit(intial.charAt(i))))
            return  false;
         else {
            s = s + intial.charAt(i);
         }
      }

      Scanner lineScanner = new Scanner(s);
      while (lineScanner.hasNext()){
         int temp = lineScanner.nextInt();
         if ( temp <= 0 ) return false;
         result.add(temp);
         sum += temp;
      }

      if (sum != SolitaireBoard.CARD_TOTAL ) return false;

      return true;

   }

   private static void testUser(ArrayList<Integer> result,Scanner in, boolean singleStep){

      System.out.println("The numeber of total cards is " + SolitaireBoard.CARD_TOTAL);
      System.out.println("Please enter the initial configuration of the cards.");
      boolean isValid = userHelper(result,in);
      //* Check if it is valid number *//
      while ( !isValid ){
         result = new ArrayList<Integer>();
         System.out.println(
                 "Error: Each piles' number must be positive and the number of total cards must be "
                         + SolitaireBoard.CARD_TOTAL );
         isValid = userHelper(result,in);
      }

      SolitaireBoard game = new SolitaireBoard(result);
      System.out.println("The inital configuration is " + game.configString());
      singleHelper(game,singleStep,in);

   }

   private static void singleHelper(SolitaireBoard game2, boolean singleStep , Scanner in){

      int i = 1;
      while (!game2.isDone()){
         game2.playRound();
         System.out.println("["+i+"] Current configuration: " + game2.configString() );
         i++;
         if (singleStep){
            System.out.println("<Type return to continue>");
            in.nextLine();
         }
      }
      System.out.println("Done!");

   }

   private static void testSingle(Scanner in , boolean singleStep ){

      SolitaireBoard game2 = new SolitaireBoard();
      System.out.println("The inital configuration is " + game2.configString());
      singleHelper(game2,singleStep,in);

   }
}