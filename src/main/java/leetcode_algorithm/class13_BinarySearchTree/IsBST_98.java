package leetcode_algorithm.class13_BinarySearchTree;


import leetcode_algorithm.class0.TreeNode;

/*

98. Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.

the value passed down will be in helper function.

 */
public class IsBST_98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, int min, int max) {
        if(root == null) {
            return true;
        }
        if(root.val <= min || root.val >= max) { // finish the judgement in this layer first.
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
