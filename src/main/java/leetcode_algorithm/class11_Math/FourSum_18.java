package leetcode_algorithm.class11_Math;

/*

Given an array S of n integers, are there elements a, b, c
and d in S such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break; //first candidate too large, search finished
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target)
                continue; //first candidate too small
            if (i > 0 && nums[i] == nums[i - 1]) continue; //prevents duplicate result in ans list
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break; //second candidate too large
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target)
                    continue; //second candidate too small
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; //prevents duplicate results in ans list
                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++; //skipping over duplicate on low
                        while (low < high && nums[high] == nums[high - 1]) high--; //skipping over duplicate on high
                        low++;
                        high--;
                    }
                    //move window
                    else if (sum < target) low++;
                    else high--;
                }
            }
        }
        return ans;
    }
}
