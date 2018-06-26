package leetcode_algorithm.class6_DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
78. Subsets

Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

重点在于：
1. 怎么画出递归数。下一层是怎么回到上一层的。
2. result添加的时候，要new一个ArrayList。
3. 知道有多少层，到底了是怎么返回去的。

唯一确定一棵树的两件事：1. 深度 2. 每一层是如何展开的。

 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) {
            return result;
        }
        ArrayList<Integer> cur = new ArrayList<>();
        dfs(nums, cur, 0, result);
        return result;
    }

    private void dfs(int[] nums, List<Integer> cur, int layer, List<List<Integer>> result) {
        if(layer == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[layer]);
        dfs(nums, cur, layer + 1, result);
        cur.remove(cur.size() - 1);
        dfs(nums, cur, layer, result);
    }

    // 不改变layer的值，改变传过去的参数的值。
    private void helper(char[] set, StringBuilder sb, int index, List<String> result){
        if(index == set.length){
            result.add(sb.toString());
            return;
        }
        sb.append(set[index]);
        helper(set, sb, index+1, result);
        sb.deleteCharAt(sb.length()-1);
        helper(set, sb, index+1, result);
    }


    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> result =  subsets.subsets(new int[]{1,2,3});
//        System.out.println(result.get(0).get(0));
        String listString = result.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println(listString);
    }
}