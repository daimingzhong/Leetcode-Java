package leetcode_algorithm.class11_Math;

/*

633. Sum of Square Numbers

Given a non-negative integer c, your task is to decide
whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: 3
Output: False

101
sqrt 1 2 ... 10
O(sqrt(n))   O(1)

dp
online algo. ??
O(sqr(n))

 */

public class SumOfSquareNumbers_633 {
    public boolean judgeSquareSum(int c) { // ugly
        int tmp = (int)Math.sqrt(c);
        for(int i = 0; i <= tmp; i++) {
            int tmp2 = c - tmp * tmp;
            int tmpSqure = (int)Math.sqrt(tmp2);
            if(tmpSqure * tmpSqure == tmp2) {
                System.out.println(tmp2);
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {// two pointer
        if (c < 0) {
            return false;
        }
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right) {
            int cur = left * left + right * right;
            if (cur < c) {
                left++;
            } else if (cur > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        SumOfSquareNumbers_633 sm = new SumOfSquareNumbers_633();
        System.out.println(sm.judgeSquareSum(1000));
    }

}