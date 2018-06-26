package leetcode_algorithm.class3_Stack_Queue;

/*

189. Rotate Array

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to
solve this problem.
[show hint]

Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II


5,6,7,1,2,3,4

为什么这题要两次翻转，因为两段长度可能不一样。

 */

public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}