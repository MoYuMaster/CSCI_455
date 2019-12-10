public class BulgarianSolitaire {
    public static void printArray(String header, int[] array, int size)
    {
        System.out.print(header);
        for(int i=0; i<size; i++)
            System.out.printf("%d ", array[i]);
        System.out.println();
    }

    //insertion sort is efficient enough for small array sizes generated here
    public static void sort(int[] arr, int cs){
        for(int i=0; i<cs; i++)
        {
            for(int j=i; j<cs; j++)
            {
                if(arr[j]<arr[i])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //check if two arrays are the same content+order
    public static boolean checkSame(int[] a, int[] goal){

        for(int i=0; i<goal.length; i++)
        {
            if(a[i] != goal[i])
                return false;
        }

        return true;
    }

    //removes zeroes from a given array, unordered removal, and returns new size of trimmed array
    public static int removeZero(int[] A, int cs) {
        for(int i=0; i<cs; i++)
        {
            if(A[i]==0 && A[cs-1]!=0)
            {
                A[i] = A[cs-1];
                cs--;
            }
            if(A[cs-1]==0)
            {
                cs--;
                i--;
            }
        }
        return cs;
    }

    public static void main(String[] args){

        int[] goal = {1,2,3,4,5,6,7,8,9};
        int[] A = new int[45];
        int total = 45;
        int currentSize = 0;
        int counter=0;

        //Form initial pile of random size >=1 and <=45

        currentSize = 5;
        A[0] = 20;
        A[1] = 5;
        A[2] = 1;
        A[3] = 9;
        A[4] = 10;
        printArray("Initial pile: ", A, currentSize);
        System.out.println("Initial # of piles: " + currentSize);

        //Start game of removing one card from each pile
        while(true)
        {
            int newPile=0;
            for(int i=0; i<currentSize ; i++)
            {
                A[i] = A[i]-1; //remove one card from each pile
                newPile++;
            }

            currentSize++;
            A[currentSize-1] = newPile; //form new pile from removed cards

            //remove any zero-ed out piles and get size of trimmed array
            currentSize = removeZero(A,currentSize);

            printArray("Intermediate pile: ", A, currentSize);
            counter++; //count number of solitaire steps

            //check if goal solitaire config has been reached
            if(currentSize==9)
            {
                sort(A,currentSize);
                boolean done = checkSame(A, goal);

                if(done) //exit if achieved
                {
                    System.out.println("***Solitaire Config Reached!!***");
                    break;
                }
            }
        }//while loop ends

        printArray("Final Array Sorted: ", A, currentSize);
        System.out.println("Number of solitaire steps needed: " + counter);
    }
}
