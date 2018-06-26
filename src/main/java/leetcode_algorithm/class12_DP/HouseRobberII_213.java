package leetcode_algorithm.class12_DP;

/*
213. House Robber II
After robbing those houses on that street, the thief has found himself a new place for his thievery
so that he will not get too much attention. This time, all houses at this place are arranged in a circle.
That means the first house is the neighbor of the last one.
Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.

 */

import java.util.Arrays;

public class HouseRobberII_213 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHelp(Arrays.copyOfRange(nums, 0, nums.length - 1)), robHelp(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int robHelp(int[] input) {
        int[] res = new int[input.length];
        res[0] = input[0];
        if(input.length == 1) {
            return res[0];
        }
        res[1] = input[1];
        if(input.length == 2) {
            return Math.max(res[0], res[1]);
        }
        res[2] = input[0] + input[2];
        if(input.length == 3) {
            return Math.max(res[1], res[2]);
        }
        for(int i = 3; i < res.length; i++) {
            res[i] = Math.max(res[i - 3], res[i - 2]) + input[i];
        }
        return Math.max(res[res.length - 1], res[res.length - 2]);
    }

    public int rob2(int[] nums) {
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }

    public int rob(int[] nums, int lo, int hi) {
        int preRob = 0, preNotRob = 0, rob = 0, notRob = 0;
        //rob / not rob.
        for (int i = lo; i <= hi; i++) {
            rob = preNotRob + nums[i];
            notRob = Math.max(preRob, preNotRob);

            preNotRob = notRob;
            preRob = rob;
        }
        return Math.max(rob, notRob);
    }

    public static void main(String[] args) {
        HouseRobberII_213 hb = new HouseRobberII_213();
        System.out.println(hb.rob(new int[]{2,7,9,3,1}));
    }
}
