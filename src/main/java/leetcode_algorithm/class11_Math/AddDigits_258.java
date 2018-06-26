package leetcode_algorithm.class11_Math;

/**
 258. Add Digits

 Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?

 ~input: 0 1 2 3 4 ...
 output: 0 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 1 2 3 ....


 */

public class AddDigits_258 {
    public int addDigits(int num) {
        return num==0?0:(num%9==0?9:(num%9));
    }
}
