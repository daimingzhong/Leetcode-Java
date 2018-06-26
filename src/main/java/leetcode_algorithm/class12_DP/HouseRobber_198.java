package leetcode_algorithm.class12_DP;
/*

198. House Robber

You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping you from
robbing each of them is that adjacent houses have security system connected and it will
automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.

   [1, 3, 7, 10, 5, 9]     nums

[0, 1, 3, 1+7, 3+10, ..]  sum

not sorted?

    [2, 1, 1, 2]
2+2 is result.

 */

public class HouseRobber_198 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] sum = new int[nums.length + 1];
        if(nums.length == 1) {
            return nums[0];
        }
        sum[1] = nums[0];
        sum[2] = Math.max(nums[0], nums[1]);
        int result = sum[2];
        for(int i = 3; i<=nums.length; i++) {
            sum[i] = Math.max(sum[i - 3], sum[i - 2]) + nums[i - 1];
            result = Math.max(result, sum[i]);
        }
        return result;
    }

    public static void main(String[] args) {
         HouseRobber_198 hs = new HouseRobber_198();
         System.out.println(hs.rob(new int[]{1,2,3,4,5}));
    }
}