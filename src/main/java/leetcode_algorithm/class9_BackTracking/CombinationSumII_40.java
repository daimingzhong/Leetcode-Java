package leetcode_algorithm.class9_BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]

 [1,1,2,5,6,7,10]
 [[1,1,6],[1,2,5],[1,7],[2,6]]

 time : O(2^n);
 space : O(n);

 bt两个值得注意的地方
 1. start -> i + 1 递归调用的起始位置
 2. Rej的判断。这题是如何判断一个数不会被用两遍。
 */


public class CombinationSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 1,1,2,5,6,7,10
        // 在两次递归里面 i == start. 即 i 作为开头都是可以的。
        // 但是不接受一个for里面遇到的连续相同的数。
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) {  //
                continue;
            }
            list.add(candidates[i]);
            // start 变成了 i + 1。不用start + 1，是因为start + 1是不变的。i + 1相当于bt里面，每次开始的头都向后移一位。

            helper(res, list, candidates, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
