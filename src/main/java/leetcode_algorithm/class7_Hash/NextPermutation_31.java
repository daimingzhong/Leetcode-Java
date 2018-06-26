package leetcode_algorithm.class7_Hash;

/*
31. Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */

import java.util.Arrays;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 1; i > 0; i--) {
            for(int j = i - 1; j > 0; j--) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                    return;
                }
            }
        }
        swap(nums, nums.length - 1, 0);
        return;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation_31 np = new NextPermutation_31();
        int[] input = new int[]{1,2,4,3};
        np.nextPermutation(input);
        System.out.println(Arrays.toString(input));

    }
}
