package leetcode_algorithm.class6_DFS;

/*

47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

之所以结果出现了两个1开头，是因为同一个1，在第二层出现了两个结果。所以并不是同一层就不会出现重复的数。
只是在下层都一样的情况下，不会出现当前层两个都一样的数。因为同一个数下面连着很多结果。


            1               2
          1   1 x
        2      x

First sort. Arrays.sort(nums);

if it has appeared in the current layer, then continue.
so for the current layer(for loop), if there has been one 1 exists, then ignore the second/third one.

each for loop is one layer, and the time complexity is O(n!)
e.g. for the first layer, there are 3 selections, and for the second one, there are two selections.


the reason for me to use dfs in for-loop is, each time we have n-layer selections.

https://discuss.leetcode.com/topic/30178/concise-java-solution-based-on-dfs
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void helper(int[] nums, int layer, List<List<Integer>> result, List<Integer> cur, boolean[] used) {
        if(layer == nums.length) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i] || (i > 0 && used[i - 1] && nums[i] == nums[i- 1])) {
                continue;
            }
            cur.add(nums[i]);
            used[i] = true;
            helper(nums, layer + 1, result, cur, used);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        PermutationsII_47 per = new PermutationsII_47();
        List<List<Integer>> result = per.permuteUnique(new int[]{1,1,2});
        for(List i : result) {
            System.out.println(i.toString());
        }
    }
}