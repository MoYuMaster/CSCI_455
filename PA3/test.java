import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add(7);
        a.add(3);
        a.add(5);
        a.add(4);
        a.add(9);
        System.out.println(a);
        a = foo(a);
        System.out.println(a);
    }

    public static ArrayList<Integer> foo( ArrayList<Integer> nums){
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(nums.get(0));
        for (int i = 1 ; i<nums.size(); i++ ){
            int loc = i-1;
            System.out.println("locpre:"+loc +"  ---   tmpNum:"+ tmp);
            while ( loc>= 0 && tmp.get(loc) > nums.get(i)){
                loc--;
            }
            tmp.add(loc+1 , nums.get(i));
            System.out.println("i:"+i+"     --     loc:"+loc );
        }
        return tmp;
    }
}
