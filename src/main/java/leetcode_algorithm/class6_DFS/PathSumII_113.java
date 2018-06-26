package leetcode_algorithm.class6_DFS;

/*

113. Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */

import leetcode_algorithm.class0.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        helper(root, sum, result, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> cur) {
        if(root == null) {
            return;
        }
        cur.add(root.val); // shall be before judgement.
        if(root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size() - 1); // don't forget to remove the last integer when success
            return;
        }
        helper(root.left, sum - root.val, result, cur);
        helper(root.right, sum - root.val, result, cur);
        cur.remove(cur.size() - 1); // don't forget to remove the last integer when success
        }
}
