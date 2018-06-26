package leetcode_algorithm.class4_BinaryTree;


import leetcode_algorithm.class0.TreeNode;

/*

110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as
a binary tree in which the depth of the two subtrees of every
node never differ by more than 1.

 */
public class IsBalanceBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1) { // first return false result.
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right); // tails recursion
    }

    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}