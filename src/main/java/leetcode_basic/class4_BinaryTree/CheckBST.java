package leetcode_basic.class4_BinaryTree;

import leetcode_basic.class0.TreeNode;


public class CheckBST {
    public boolean checkBST(TreeNode root) {
         return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, int min, int max) {
        if (root == null) {
            return  true;
        }
        if(root.key <= min || root.key>= max){
            return false;
        }
        return checkBST(root.left, min, root.key ) && checkBST(root.right, root.key, max);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left  = t4;
        t2.right = t5;
        CheckBST check = new CheckBST();
        //System.out.println(t1.key);
        System.out.println(check.checkBST(t1));

    }
}
