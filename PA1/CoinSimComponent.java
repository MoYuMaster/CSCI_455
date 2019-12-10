// Name:Yaochun Li
// USC NetID:yaochunl
// CS 455 PA1
// Fall 2019

import java.awt.*;
import java.lang.Math;
import javax.swing.*;

// Extends JComponent. Constructor initializes any necessary data and runs the simulation. //
// Overrides paintComponent to draw the bar graph, using Bar objects for each bar in the graph. //
// This class uses the CoinTossSimulator and Bar class.//

public class CoinSimComponent extends JComponent {

    private int TwoHeads,TwoTails,HeadTails,NumTrials ;
    private double PerTwoHeads,PerTwoTails,PerHeadTails;

    public CoinSimComponent(int numTrials){

        CoinTossSimulator coinTossSimulator = new CoinTossSimulator();
        coinTossSimulator.run( numTrials );

        TwoHeads=coinTossSimulator.getTwoHeads();
        TwoTails=coinTossSimulator.getTwoTails();
        HeadTails=coinTossSimulator.getHeadTails();
        NumTrials=coinTossSimulator.getNumTrials();

        PerTwoHeads=(double)TwoHeads/NumTrials;
        PerTwoTails=(double)TwoTails/NumTrials;
        PerHeadTails=(double)HeadTails/NumTrials;

    }

    public void paintComponent(Graphics graphics){
        Graphics2D g2 = (Graphics2D)graphics;

        int totalWidth = getWidth();
        int totalHeight = getHeight();
        int bottom = (int)(totalHeight*0.86);
        //  fiexed value//
        int width = 60;

        //left point for 3 case , 1/7 = 0.14,3/7 = 0.42,5/7 = 0.7 //
        int leftHH = (int)(totalWidth*0.14);
        int leftHT= (int)(totalWidth*0.42);
        int leftTT= (int)(totalWidth*0.7);


        // barHeight for 3 case //
        int barHeightHH = (int)(PerTwoHeads* totalHeight * 0.8);
        int barHeightHT= (int)(PerHeadTails* totalHeight * 0.8);
        int barHeightTT = (int)(PerTwoTails* totalHeight * 0.8);


        // scale for 3 case //
        double scaleHH = PerTwoHeads;
        double scaleHT = PerHeadTails;
        double scaleTT = PerTwoTails;

        // string for 3 case //
        String sHH = "Two Heads: " + TwoHeads +"(" + Math.round(PerTwoHeads*100) + "%)";
        String sHT = "HeadTails: " + HeadTails +"(" + Math.round(PerHeadTails*100) + "%)";
        String sTT = "TwoTails: " + TwoTails +"(" + Math.round(PerTwoTails*100) + "%)";


        //Bar(int bottom, int left, int width, int barHeight,//
        //       double scale, Color color, String label)    //
        Bar barHH = new Bar(bottom,leftHH,width,barHeightHH,scaleHH,Color.red,sHH);
        Bar barHT = new Bar(bottom,leftHT,width,barHeightHT,scaleTT,Color.green,sHT);
        Bar barTT = new Bar(bottom,leftTT,width,barHeightTT,scaleHT,Color.blue,sTT);


        // draw //
        barHH.draw(g2);
        barHT.draw(g2);
        barTT.draw(g2);

    }

}
