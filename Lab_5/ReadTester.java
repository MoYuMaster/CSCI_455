import java.util.ArrayList;
import java.util.Scanner;

public class ReadTester {
    public static void main(String[] args){

        while (true) {
            ArrayList<Integer> array = new ArrayList<Integer>();
            String string = "";

            Scanner in = new Scanner(System.in);
            System.out.print("Enter a space separated list of numbers: ");
            // Scan the whole line //
            if (in.hasNextLine()) {
                string = in.nextLine();
            }

            Scanner out = new Scanner(string);
            // Invert to int , add to array //
            while (out.hasNextInt()) {
                int a = out.nextInt();
                array.add(a);
            }
            System.out.println("The numbers were: "+ array);

    }
}
}
