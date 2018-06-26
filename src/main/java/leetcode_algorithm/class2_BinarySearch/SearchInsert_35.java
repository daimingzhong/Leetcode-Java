package leetcode_algorithm.class2_BinarySearch;

/**
 * 35. Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * <p>
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SearchInsert_35 {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] >= target) {
                return 0;
            } else {
                return 1;
            }
        }
        return search(nums, 0, nums.length, target);
    }

    public static int search(int[] nums, int left, int right, int target) {
        int middle = left + (right - left) / 2;
        if (left == right - 1) {
            if (nums[left] >= target) {
                return left;
            } else {
                return right;
            }
        }
        if (nums[middle] >= target) {
            right = middle;
        } else {
            left = middle;
        }
        return search(nums, left, right, target);
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
    }
}
