// Name:Yaochun Li
// USC NetID:yaochunl
// CS 455 PA1
// Fall 2019

import java.awt.*;
import java.util.Scanner;
import javax.swing.JFrame;


public class CoinSimViewer {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number of trials:");
        int trialsNum = input.nextInt();

        // in case num<0  //
        while ( trialsNum <= 0 ){

            System.out.println("Warning : Please enter the number greater than 0.");
            System.out.println();
            System.out.print("Please enter the number of trials:");
            trialsNum = input.nextInt();

        }

        // initialize the JFrame //
        JFrame frame = new JFrame();
        frame.setTitle("CoinSim");
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CoinSimComponent component = new CoinSimComponent( trialsNum );
        frame.add(component);

        // display //
        frame.setVisible(true);

    }
}
