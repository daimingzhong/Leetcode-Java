package leetcode_algorithm.class12_DP;

/*

53. Maximum Subarray

Find the contiguous subarray within an array (containing at least one number)
which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

If you have figured out the O(n) solution
try coding another solution using the divide and conquer approach, which is more subtle.



 */

public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length + 1];
        int target = nums[0];
        for(int i = 0; i<nums.length; i++) {
            sum[i+1] = Math.max(sum[i] + nums[i], nums[i]);
            target = Math.max(sum[i + 1], target);
        }
        return target;
    }

    public static void main(String[] args) {
     MaximumSubarray_53 mx = new MaximumSubarray_53();
     System.out.println(mx.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
