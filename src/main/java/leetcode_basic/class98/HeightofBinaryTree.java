package leetcode_basic.class98;


import leetcode_basic.class0.TreeNode;

/**
 * Created by Dai on 2017/1/1.
 */
public class HeightofBinaryTree {
    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findHeight(root.left), findHeight(root.right))+ 1;
    }
}