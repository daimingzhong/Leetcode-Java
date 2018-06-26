package leetcode_algorithm.class6_DFS;

/*

112. Path Sum

Given a binary tree and a sum, determine if the tree has a
root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5               layer 1
             / \
            4   8            layer 2
           /   / \
          11  13  4         layer 3
         /  \      \
        7    2      1      layer 4
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


 */


import leetcode_algorithm.class0.TreeNode;

public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        int curVal = 0;
        return helper(root, curVal, sum);
    }

    private boolean helper(TreeNode root, int curVal, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            if(curVal + root.val == sum){
                return true;
            } else {
                return false;
            }
        }
        return (helper(root.left, root.val + curVal, sum) || helper(root.right, root.val + curVal, sum));
    }
}
