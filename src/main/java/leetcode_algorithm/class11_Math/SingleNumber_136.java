package leetcode_algorithm.class11_Math;

/*

136. Single Number

Given an array of integers, every element appears twice except for one.
Find that single one.

Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?


1 2 2 3 1

a ^ b ^ b = a
a ^ 0 = a
 */

public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result = (result ^ i);
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber_136 sg = new SingleNumber_136();
        int re =  sg.singleNumber(new int[]{1,1,3,2,3});
        System.out.println(re);
    }
}