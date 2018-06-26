package leetcode_algorithm.class14_Array;

import java.util.HashMap;


public class TwoSum_1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap hashMap = new HashMap();
        int left = 0, right = 0; // must initialize here. or we can not return.
        for(int i = 0; i<nums.length; i++) {
            if(hashMap.containsKey(target - nums[i])) {
                left = (int)hashMap.get(target - nums[i]);
                right = i;
                break;
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {

        System.out.println(twoSum(new int[]{1,2,3,4},5)[0]);
    }
}