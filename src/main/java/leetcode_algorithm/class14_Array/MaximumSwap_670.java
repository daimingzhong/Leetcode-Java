package leetcode_algorithm.class14_Array;

/*
670. Maximum Swap

Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 108]

因为我只能翻一次，所以我只记录最后一个。

    2   3   1   2   1   2

    buckets

    0   1   2   3...                9
        2   0   1
            3
            5
 */

public class MaximumSwap_670 {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }

    public static void main(String[] args){
        MaximumSwap_670 mx = new MaximumSwap_670();
        int res = mx.maximumSwap(23145);
        System.out.println(res);
    }
}