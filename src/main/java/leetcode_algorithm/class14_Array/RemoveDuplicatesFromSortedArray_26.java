package leetcode_algorithm.class14_Array;

/*

26. Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element appear
only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2,
with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the new length.


 1                1                 2
 slow             fast
 fast             fast              fast

 */

public class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        int slow = 1;
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                slow++;
                swap(nums, i, slow);
            }
        }
        return slow;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        int j=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = nums[i];
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray_26 rm = new RemoveDuplicatesFromSortedArray_26();
        int result = rm.removeDuplicates(new int[]{1, 1});
        System.out.println(result);
    }
}
