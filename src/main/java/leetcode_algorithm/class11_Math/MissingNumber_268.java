package leetcode_algorithm.class11_Math;

/*

268. Missing Number

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n
find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Your algorithm should run in linear runtime complexity.
Could you implement it using only constant extra space complexity?

 */

import java.util.Arrays;

public class MissingNumber_268 {
    public int missingNumber(int[] nums) { //xor
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    public int missingNumber2(int[] nums) { //sum
        int len = nums.length;
        int sum = (0+len)*(len+1)/2;
        for(int i=0; i<len; i++)
            sum-=nums[i];
        return sum;
    }

    public int missingNumber3(int[] nums) { //binary search
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid= (left + right)/2;
        while(left<right){
            mid = (left + right)/2;
            if(nums[mid]>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }
}