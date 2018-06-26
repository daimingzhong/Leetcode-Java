package leetcode_algorithm.class11_Math;

/*

367. Valid Perfect Square

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False

1  1
4  2
9  3

16 4

100 10

binary search    O(log n)
slow fast


        100

   0    100

mid      50

 */

public class ValidPerfectSquare_367 {
    public boolean isPerfectSquare(int num) {
        if(num == 1) {
            return true;
        }
        int slow = 0, fast = num;
        while(slow < fast - 1) {
            int mid = (fast + slow) >>> 1;
//            long tmp = (long)mid * mid;
            long tmp = (long)mid * mid;
            if(tmp > num) {  // mid * mid can be overflow
                fast = mid;
            } else {
                slow = mid;
            }
        }
//        System.out.println(slow);
//        System.out.println(fast);
        return (slow * slow == num || fast * fast == num);
    }

    public static void main(String[] args) {
        ValidPerfectSquare_367 vp = new ValidPerfectSquare_367();
        System.out.println(vp.isPerfectSquare(16));
    }
}