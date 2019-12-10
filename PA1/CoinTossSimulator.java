// Name:Yaochun Li
// USC NetID:yaochunl
// CS 455 PA1
// Fall 2019
/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */

import java.util.Random;
import java.lang.Math;

public class CoinTossSimulator {

   private int TwoHeads,TwoTails,HeadTails,NumTrials ;
   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      TwoHeads = 0;
      TwoTails = 0;
      HeadTails = 0;
      NumTrials = 0;
   }

   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */

   public void run(int numTrials) {

      this.NumTrials = this.NumTrials + NumTrials;
      for (int i = 0; i< numTrials ; i++){

         Random random = new Random();
         // [0,2) //
         int case1 = random.nextInt(2);
         int case2 = random.nextInt(2);
         // 0 = Heads , 1 = Tails //
         if( case1 == 0 && case2 == 0 ){
            TwoHeads++;
         }
         else if (case1 == 1 && case2 == 1){
            TwoTails++;
         }
         else {
            HeadTails++;
         }
      }
   }

   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials(){
      NumTrials = TwoHeads + TwoTails + HeadTails;
      return NumTrials;
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return TwoHeads;
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
      return TwoTails;
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return  HeadTails;
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      TwoTails = 0;
      TwoHeads = 0;
      HeadTails = 0;
      NumTrials = 0;

   }

}
