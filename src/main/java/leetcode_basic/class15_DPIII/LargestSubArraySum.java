package leetcode_basic.class15_DPIII;

import java.util.PriorityQueue;

/**
 * Created by Dai on 2017/1/3.
 {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
 {-2, -1, -3}, the largest subarray sum is -1
 时间复杂度n2
 每个解为包含自身的当前最大值。
 */
public class LargestSubArraySum {
    public int largestSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] result = new int[array.length];
        result[0]  = array[0];
        int sol = array[0];
        for (int i = 1; i < array.length; i++) {
            if (result[i - 1] > 0) {
                result[i] = result[i - 1] + array[i];
            } // else, result[0] is 0; don't need to do anything
            // 其实不对，array[i] < 0 的时候，要单独处理。
            else {
                result[i] = array[i];
            }
            sol = Math.max(result[i], sol); // 如果要在math里用到，要初始化
        }
        return sol;
    }

    public static void main(String[] args) {
        LargestSubArraySum ls = new LargestSubArraySum();
        int result = ls.largestSum(new int[]{-4,-6,-2,-3});
        System.out.print(result);
    }
}