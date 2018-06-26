package leetcode_algorithm.class2_BinarySearch;

/*

34. Search for a Range

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

        [5, 7, 7, 8, 8, 10]
index    0                5
               2
               left       right
 */

public class SearchForARange_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target || (nums.length == 1 && nums[0] != target)) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }
        return new int[]{findStart(nums, target), findEnd(nums, target)};
    }

    private int findStart(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    private int findEnd(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchForARange_34 sf = new SearchForARange_34();
        int[] result = sf.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}