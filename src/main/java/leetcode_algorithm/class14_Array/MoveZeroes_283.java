package leetcode_algorithm.class14_Array;

/*

283. Move Zeroes

Given an array nums, write a function to move all 0's to the end of
it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

first: swap the value of slow and fast, then slow++.

 */

public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int i =0; i <= nums.length-1; i++) {
            if (nums[i] != 0){
                int tmp = nums[slow];
                nums[slow] = nums[i];
                nums[i] = tmp;
                slow++;
            }
        }
    }
}