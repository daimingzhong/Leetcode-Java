package leetcode_algorithm.class14_Array;

/*
674. Longest Continuous Increasing Subsequence
Given an unsorted array of integers, find the length of longest continuous increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 */

public class LongesContinuousIncreasingSubsequence_674 {
    public int findLengthOfLCIS(int[] nums) {
        int max = 1, tmp = 1;
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        for(int i = 1 ; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                tmp++;
                max = Math.max(max, tmp);
            } else {
                tmp = 1;
            }
        }
        return max;
    }
}

