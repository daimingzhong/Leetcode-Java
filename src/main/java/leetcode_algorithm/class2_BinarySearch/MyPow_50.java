package leetcode_algorithm.class2_BinarySearch;

/**
 * 50. My power
 * Implement pow(x, n).
 * suppose n >= 0.
 */

public class MyPow_50 {
    public static double myPow(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        if(n == 1) {
            return x;
        }
        if(n == -1) {
            return 1/x;
        }
        if (n%2 == 0) {
            return Math.pow(myPow(x, n/2), 2);
        } else {
            if (n > 0) {
                return Math.pow(myPow(x, n/2), 2) * x;
            } else {
                return Math.pow(myPow(x, n/2), 2) * 1/x;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(myPow(2,-3));
    }
}