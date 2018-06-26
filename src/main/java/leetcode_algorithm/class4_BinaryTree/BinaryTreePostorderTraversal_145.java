package leetcode_algorithm.class4_BinaryTree;

/*

145. Binary Tree Postorder Traversal

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

左  右  中

 */


import leetcode_algorithm.class0.TreeNode;

import java.util.*;

public class BinaryTreePostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            helper(root.left, res);
        }
        if(root.right != null) {
            helper(root.right, res);
        }
        res.add(root.val);
    }


    // post order （左右中，中右左再倒过来）
    public List<TreeNode> dfs (TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> res = new LinkedList<>();
        while(!stack.isEmpty() || root!= null) {
            if (root != null) {
                res.add(0, root);
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        return res;
    }

}