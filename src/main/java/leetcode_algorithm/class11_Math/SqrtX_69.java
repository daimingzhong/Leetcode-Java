package leetcode_algorithm.class11_Math;

/*
69. Sqrt(x)

implement int sqrt(int x).

Compute and return the square root of x.
 */

public class SqrtX_69 {

    public int mySqrt(int x) {
        if(x == 1) {
            return 1;
        }
        int slow = 0, fast = x;
        while(slow < fast - 1) {
            int mid = (fast + slow) >>> 1;
            long tmp = (long)mid * mid; // mid * mid can be overflow
            if(tmp > x) {
                fast = mid;
            } else {
                slow = mid;
            }
        }
//        System.out.println(slow);
//        System.out.println(fast);
        return slow;
//        return (slow * slow == x || fast * fast == x);
    }

    public static void main(String[] args) {
        SqrtX_69 vp = new SqrtX_69();
        System.out.println(vp.mySqrt(26));
    }
}