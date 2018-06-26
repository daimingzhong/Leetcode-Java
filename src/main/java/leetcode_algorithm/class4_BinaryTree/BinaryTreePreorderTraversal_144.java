package leetcode_algorithm.class4_BinaryTree;

/*

144. Binary Tree Preorder Traversal

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].


 */


import leetcode_algorithm.class0.TreeNode;

import java.util.*;


public class BinaryTreePreorderTraversal_144 {


    /*
     2
    / \
   1  3
preorder -> 1, 2, 3
     */
    public List<Integer> preOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        result.add(root.val);
        if(root.left != null) {
            helper(root.left, result);
        }
        if (root.right != null) {
            helper(root.right, result);
        }
    }


}
