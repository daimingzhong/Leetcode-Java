package leetcode_algorithm.class6_DFS;

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) {
        return result;
    }
    Arrays.sort(nums);
    ArrayList<Integer> cur = new ArrayList<>();
    dfs(nums, cur, 0, result);
    return result;
}

    // for current layer, determine if the element will be added.
    private void dfs(int[] nums, List<Integer> cur, int layer, List<List<Integer>> result) {
        if(layer == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[layer]);
        dfs(nums, cur, layer + 1, result);
        cur.remove(cur.size() - 1);
        while(layer < nums.length - 1 && nums[layer] == nums[layer + 1]) { // 为什么？？？
            layer++;
        }
        dfs(nums, cur, layer + 1, result);
    }

    public static void main(String[] args) {
        SubSetsII subsets = new SubSetsII();
        List<List<Integer>> result =  subsets.subsetsWithDup(new int[]{1,2,2});
        String listString = result.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println(listString);
    }
}
