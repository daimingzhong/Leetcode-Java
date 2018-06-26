package leetcode_basic.class21_PracticeII;


import leetcode_basic.class0.TreeNode;

/**
 * Created by Dai on 2016/12/30.
 *       5
      /   \
    2     11
  /  \
 6   14

 largest number smaller than 1 is Integer.MIN_VALUE(Java) or INT_MIN(c++)
 largest number smaller than 10 is 6
 largest number smaller than 6 is 5
 两种方法：
 1. 递归
 2. 迭代 通过修改while循环里的参数，作为动力 1,3的逻辑是一样的，可以省略一个。
    重点是先分析好大于，小于，等于的时候，分别往哪个方向走，再写代码。
 */
public class LargestNumberSmallerInBinarySearchTree {
    public int largestSmaller(TreeNode root, int target) {
        int result = Integer.MIN_VALUE;
        while(root != null){
            if (root.key < target && root.key > result) {
                result = root.key;
            }
            if (root.key >= target){
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return result;
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
        LargestNumberSmallerInBinarySearchTree ln = new LargestNumberSmallerInBinarySearchTree();
        int result = ln.largestSmaller(t1,6);
        System.out.println(result);
    }
}
