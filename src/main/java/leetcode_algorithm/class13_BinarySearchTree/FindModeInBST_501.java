package leetcode_algorithm.class13_BinarySearchTree;


import leetcode_algorithm.class0.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 501. Find Mode in Binary Search Tree

 Given a binary search tree (BST) with duplicates,
 find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2]

   1
    \
     2
    /
   2
 return [2].

 Note: If a tree has more than one mode, you can return them in any order.
 Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).


 dp + tree.
 全局最大值 + tree.

 https://discuss.leetcode.com/topic/77335/proper-o-1-space

 */

public class FindModeInBST_501 {
    public int[] findMode(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        traverse(root, list);
        return null;
    }

    public void traverse(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        if (root.left != null) {
            list.add(root.left);
            traverse(root.left, list);
        } else if (root.right != null) {
            list.add(root.right);
            traverse(root.right, list);
        }
    }

    public void traverse2(TreeNode root, List<TreeNode> list) {
        while(!list.isEmpty()) {
            list.add(root.left);
        }

    }


    public int[] findMode2(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
    }

    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;

    private int[] modes;

    private void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null)
                modes[modeCount] = currVal;
            modeCount++;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }
}
