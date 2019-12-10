// Name:Yaochun Li
// USC NetID:yaochunl
// CS 455 PA1
// Fall 2019


public class CoinTossSimulatorTester {
    public static void main(String[] args){

        CoinTossSimulator coinTossSimulator = new CoinTossSimulator();

        boolean testCorrectness = ( coinTossSimulator.getNumTrials() ==
                (coinTossSimulator.getTwoHeads()+coinTossSimulator.getTwoTails()+coinTossSimulator.getHeadTails()) );

        System.out.println("After constructor:");
        System.out.println("Number of trails [exp:0]: " + coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses: " + coinTossSimulator.getTwoHeads());
        System.out.println("Two-tail tosses: " + coinTossSimulator.getTwoTails());
        System.out.println("One-head one-tail tosses: " + coinTossSimulator.getHeadTails());
        System.out.println("Tosses add up correctly? "+ testCorrectness);
        System.out.println();


        // Try 3 cases //
        int[] NumTrials = {1,10,100};
        for(int i = 0;i<NumTrials.length;i++){

            int nums = NumTrials[i];
            coinTossSimulator.run(nums);
            int expectedNums = coinTossSimulator.getTwoHeads()+coinTossSimulator.getTwoTails()+coinTossSimulator.getHeadTails();
            System.out.println("After run(" + nums + "):");
            System.out.println("Number of trails[exp:"+expectedNums+"]: " + coinTossSimulator.getNumTrials());
            System.out.println("Two-head tosses: " + coinTossSimulator.getTwoHeads());
            System.out.println("Two-tail tosses: " + coinTossSimulator.getTwoTails());
            System.out.println("One-head one-tail tosses: " + coinTossSimulator.getHeadTails());
            System.out.println("Tosses add up correctly? "+ testCorrectness);
            System.out.println();

        }

        // Reset //
        coinTossSimulator.reset();
        System.out.println("After reset: ");
        System.out.println("Number of trails [Expected:0]: " + coinTossSimulator.getNumTrials());
        System.out.println("Twoheads Toss: " + coinTossSimulator.getTwoHeads());
        System.out.println("TwoTails Toss: " + coinTossSimulator.getTwoTails());
        System.out.println("One Head-One Tail Toss: " + coinTossSimulator.getHeadTails());
        System.out.println("Tosses add up correctly? "+ testCorrectness);
        System.out.println();

        // one more test for 1000 //
        coinTossSimulator.run(1000);
        System.out.println("After run(1000):");
        System.out.println("Number of trails [exp:1000]: " + coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses: " + coinTossSimulator.getTwoHeads());
        System.out.println("Two-tail tosses: " + coinTossSimulator.getTwoTails());
        System.out.println("One-head one-tail tosses: " + coinTossSimulator.getHeadTails());
        System.out.println("Tosses add up correctly? "+ testCorrectness);
        System.out.println();

    }
}
