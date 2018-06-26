package leetcode_basic.class4_BinaryTree;

import leetcode_basic.class0.TreeNode;

/**
 * Created by Dai on 2017/1/14.
 */
public class IsBinarySearchTree {
    public boolean isBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return helper(root, min, max);
    }
    private boolean helper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.key <= min || root.key >= max) {
            return false;
        }
        return helper(root.left, min, root.key) && helper(root.right, root.key, max);
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        //t2.right = t4;
        IsBinarySearchTree is = new IsBinarySearchTree();
        boolean result = is.isBST(t1);
        System.out.println(result);
    }

}
