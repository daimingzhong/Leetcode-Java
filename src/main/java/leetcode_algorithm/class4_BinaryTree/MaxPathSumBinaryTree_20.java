package leetcode_algorithm.class4_BinaryTree;

/*
Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf node to another leaf node. If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).

Examples

  -15

  /    \

2      11

     /    \

    6     14

The maximum path sum is 6 + 11 + 14 = 31.

先左右，再处理。后序遍历。
后序遍历的好处是，总能处理完子节点，再把他们一锅炖了。
这题就是点到点，那么肯定是后序遍历。

先得到left, right。然后在处理left，right。
if == null 返回0.
left = , right =
if .left && .right != null. add大的。
有一个空？另一个的结果和0比较。
 */


import leetcode_algorithm.class0.TreeNode;

public class MaxPathSumBinaryTree_20 {

    public int maxPathSum (TreeNode root) {
        int max[] = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode node, int[] result) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left, result);
        int right = helper(node.right, result);    // step1
        if (node.left != null && node.right != null) {
            // 有左右的时候，才比较结果。
            result[0] = Math.max(result[0], left + right + node.val);
            return Math.max(left, right) + node.val;    // Step 3a
        }
        // 只有一个分支，就返回该分支的值。如果一个分支都没有，其实返回的是 0 + node.val
        return node.left == null ? right + node.val : left + node.val;   // Step 3b
    }
}
