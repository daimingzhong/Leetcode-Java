package leetcode_algorithm.class6_DFS;

/*

46. Permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


      1     2       3
    2  3
   3    2

use an array to record if the element has been used or not.
1. used, ignore
2. not used -> add to cur, and mark as used.

time O(n!)
space O(n!)

这题的难点，是画出递归树。

                            123

layer0            1(23)           2(13)           3(12)
                   /
layer1         12(3)   13(2)
                /
layer2       123

 */

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, 0, used, result, new ArrayList<Integer>());
        return result;
    }

    private void helper(int[] nums, int layer, boolean[] used, List<List<Integer>> result, List<Integer> cur) {
        if(layer == nums.length) {
            result.add(new ArrayList<Integer>(cur)); //result.add(cur); 注意
            return;
        }
        for(int i = 0; i<nums.length; i++) {
            if(!used[i]) {
                cur.add(nums[i]);
                used[i] = true;
                helper(nums, layer+1, used, result, cur); // 为什么这里要调一次，直接cur加不就好了么。不行是因为要减。
                used[i] = false;
                cur.remove(cur.size() - 1);
            } // else do nothing. so in each layer, there exists actually 3 selections.
        }
    }

    public static void main(String[] args) {
        Permutations_46 per = new Permutations_46();
        List<List<Integer>> result = per.permute(new int[]{1,2,3});
        for(List i : result) {
            System.out.println(i.toString());
        }
    }
}