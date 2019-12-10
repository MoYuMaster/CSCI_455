import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Duration n1 = new Duration(100);
        Duration n2 = new Duration(2,30);
        n1.add(n2);
        n1.increase(1,20);
        n1.toString();
        System.out.println(n1);
    }



}
