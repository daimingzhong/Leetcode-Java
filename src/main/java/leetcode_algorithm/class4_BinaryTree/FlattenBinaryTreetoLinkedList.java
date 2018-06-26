package leetcode_algorithm.class4_BinaryTree;


import leetcode_algorithm.class0.TreeNode;

import java.util.Stack;

/**
 * For example,
 Given

     1
    / \
   2   5
  / \   \
 3   4   6
 The flattened tree should look like:
 1
  \
  2
   \
    3
    \
     4
      \
       5
       \
        6

 time : O(n)
 space : O(n)

 */

public class FlattenBinaryTreetoLinkedList {

    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    /*
    用stack，先存右边，再存左边。dfs

    对stack里的node，pop出来，存 右 左

    对 cur 拿 stack 里存的头。这个非常natural。

     */

    public void flatten2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (!stack.isEmpty()) {
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }
}
