package leetcode_algorithm.class13_BinarySearchTree;

/*
173. Binary Search Tree Iterator

Implement an iterator over a binary search tree (BST).
Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.


                    1
                  2   3
                4

在一个stack里存最小值，并不改变树的结构。
dfs。遍历左边，再把当前的node转到右边去。


 */


import leetcode_algorithm.class0.TreeNode;

import java.util.Stack;

public class BSTIterator_173 {

    private Stack<TreeNode> stack;
    private TreeNode cur;

    public BSTIterator_173(TreeNode root) {
        stack = new Stack<>();
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }

    /** @return the next smallest number */
    public int next() {
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode t = stack.pop();
        cur = t.right;
        return t.val;
    }
}
