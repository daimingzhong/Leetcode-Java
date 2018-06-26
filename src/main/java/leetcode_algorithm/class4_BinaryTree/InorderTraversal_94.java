package leetcode_algorithm.class4_BinaryTree;


import leetcode_algorithm.class0.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 94. Binary Tree Inorder Traversal

 Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree [1,null,2,3],
 1
  \
   2
  /
  3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?

 Question: First go down or first handle current layer.
 Note that go down first is OK. and there can be no problems to handle this layer until return back.

 we shall consider two things when we are using recursion:
 first:
 second: what we are going to do after return back to current layer.

 */

public class InorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List result) {
//        if(root == null) { // it will never be null. because we have decided not to go down when it is null
//            return;
//        }
        if(root.left != null) {
            helper(root.left, result);
        }
        result.add(root.val);
        if(root.right != null) {
            helper(root.right, result);
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> list = new LinkedList<>();
        TreeNode cur = root;
        while(cur != null || !list.isEmpty()) {
            while(cur != null) {
                list.add(cur);
                cur = cur.left;
            }
            cur = list.pollLast();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
