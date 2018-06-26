package leetcode_basic.class21_PracticeII;


import leetcode_basic.class0.TreeNode;

/**
 * Created by Dai on 2016/12/30.
 * Examples:
      5
    /  \
   2  11
 /    \
 6     14

 closest number to 4 is 5
 closest number to 10 is 11
 closest number to 6 is 6
 这个题的难点，是在每次递归的时候，传递两个参数，一个是结果，一个是目标。
 两种方法：
 1. backtrap
 2. bfs
 因为是bst，所以只要走height就行，递归和循环都可以。

 */
public class ClosestNumberInBinarySearchTree {
    public int closest(TreeNode root, int target) {
        int[] result = {root.key};
        helper(root, result, target);
        return result[0];
    }

    private void helper(TreeNode root, int[] result, int target) {
        if (root == null) {
            return;
        }
        if (Math.abs(root.key - target) < Math.abs(result[0] - target)) {
            result[0] = root.key;//更新result
        }
        if (root.key < target) {
            helper(root.right, result, target);
        } else if (root.key > target) {
            helper(root.left, result, target);
        } else {
            return;
        }
    }

    public int closest2(TreeNode root, int target) {
        //
        return 0;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(5);
        /*
                6
              /  \
            4     7
           / \
          1  5
         */
        t1.left = t2;
        t1.right = t3;
        t2.left  = t4;
        t2.right = t5;
        ClosestNumberInBinarySearchTree cl = new ClosestNumberInBinarySearchTree();
        int result = cl.closest(t1,2);
        System.out.println(result);
    }
}
