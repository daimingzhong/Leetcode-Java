package leetcode_basic.class4_BinaryTree;

import leetcode_basic.class0.TreeNode;

/**
        5
     /    \
   3        8
  /   \        \
 1      4        11

 is balanced binary tree,

 *          2
 *        /  \
 *      1     5
 *    /  \
 *  null 7
 *
 *
 */

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (height(root) == -1 ) {
            return false;
        }
        return true;
    }
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeigh = height(root.left);
        if (leftHeigh == -1) {
            return -1;
        }
        int rightHeight = height(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeigh - rightHeight) > 1) {
            return -1;
        }
        return Math.max(height(root.left), height(root.right)) + 1 ;
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        IsBalanced ib = new IsBalanced();
        System.out.println(ib.isBalanced(t1));
    }
}
