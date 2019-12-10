

public class Test {

    public static int removeN(int[] nums, int size){

        for (int i = size-1;i>=0;i--){
            if (nums[i]<0){
                for(int j=i;j<size-1;j++){
                    nums[j] = nums[j+1];
                }
                nums[size-1] = 0;
                size--;
            }
        }
        System.out.println(size);
        return size;


    }

    public static void main(String[] args) {
        Test test1 = new Test();
        int[] in = {-3,-3,9,-8};
        int a =3,b=6;
        if (a <= b);
        {a=a+b;};
        System.out.println(a);
    }
}
