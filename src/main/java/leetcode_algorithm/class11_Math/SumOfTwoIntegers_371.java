package leetcode_algorithm.class11_Math;

/*

371. Sum of Two Integers

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.


        1 0 1
        1 1 1
xor     0 1 0   表示不考虑进位的情况的结果
a&b     1 0 1   表示进位

     010
    1010
    1000
    0010 0

 */



public class SumOfTwoIntegers_371 {
    public int getSum(int a, int b) {
        if(b == 0){//没有进位的时候完成运算
            return a;
        }
        int sum, carry;
        sum = a^b;//完成第一步加发的运算
        carry = (a&b)<<1;//完成第二步进位并且左移运算
        return getSum(sum,carry);//
    }
}
