package leetcode_algorithm.class11_Math;

/*

338. Counting Bits
Given a non negative integer number num.
For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's
in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:
It is very easy to come up with a solution with run time O(n*sizeof(integer)).
But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss?
Do it without using any builtin function like __builtin_popcount in c++
or in any other language.


dp:

    1 0  1
    1  0 1  0
 the next one is twice of the first one. and the number of zero is f(a/2) + a&1.

 */

public class CountingBits_338 {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for(int i = 1; i<=num; i++) {
            result[i] = result[i>>1] + (i&1); //注意括号
        }
        return result;
    }

    public static void main(String[] args) {
        CountingBits_338 cn = new CountingBits_338();
        for(int i : cn.countBits(5)) {
            System.out.println(i);
        }
    }
}