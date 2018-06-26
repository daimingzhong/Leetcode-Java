package leetcode_algorithm.class14_Array;

/*
673. Number of Longest Increasing Subsequence
Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1,
and there are 5 subsequences' length is 1, so output 5.

https://discuss.leetcode.com/topic/103020/java-c-simple-dp-solution-with-explanation/2

res[] 表示在当前点，最长的路径值
path[] 有多少path到达当前的res。


res[i] = res[j] + 1，那么就是res[j]的下一个点，那么所有去j的都能到i。那么久是 += j.
res[i] < res[j] + 1，说明需要更新。至少有path[j]种方法。
res[i] > res[j] + 1, 不需要更新。因为不需要2来更新4的路径数。4只要3来更新。
 */

public class NumberOLongestIncreasingSubsequence_673 {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0 ) {
            return 0;
        }
        int max = 0, result = 0;
        int[] res = new int[nums.length];
        int[] path = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = path[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (res[i] < res[j] + 1) { // 当前最长路径
                        res[i] = res[j] + 1;
                        path[i] = path[j]; //当前套路数
                    } else if(res[i] == res[j] + 1) { //
                        path[i] += path[j];
                    } // 大于 j + 1就不处理。
                }
            }
            if(max == res[i]) {
                result += path[i];
            }
            if(max < res[i]) {
                max = res[i];
                result = path[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        NumberOLongestIncreasingSubsequence_673 nl = new NumberOLongestIncreasingSubsequence_673();
        int res = nl.findNumberOfLIS(new int[]{5,5,5,5,5}); //1,3,5,4,7
        System.out.println(res);
    }
}
