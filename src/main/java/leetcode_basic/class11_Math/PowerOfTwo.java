package leetcode_basic.class11_Math;

/**
 * Created by Dai on 2016/11/9.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo (int number) {
        if (number == 0) {
            return false;
        }
        while (number % 2 == 0) {
             number = number / 2 ;
        }
        return  (number == 1)? true: false;
    }
    public static void main (String[] args) {
        int a = 1; // 1 = 2 pf power 0
        PowerOfTwo checkTwo = new PowerOfTwo();
        System.out.print(checkTwo.isPowerOfTwo(a));
    }
}
