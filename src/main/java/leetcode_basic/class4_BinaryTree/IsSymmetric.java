package leetcode_basic.class4_BinaryTree;

import leetcode_basic.class0.TreeNode;

/**
          5
       /   \
     3      3
   / \     / \
 1    4  4   1

 is symmetric
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode one, TreeNode two) {
        // 这题在当前层，就有足够信息处理，需要的是当前层的两个node的值。所以在当前层处理。
        // 递归在当前处理完之后写，因为递归还是处理“当前层”，每次返回false，直到最后null返回true。
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }
        return isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        boolean[] result = {true};
        helper(root, result);
        return result[0];
    }

    public void helper(TreeNode root, boolean[] result) {
        if(root.left == null && root.right == null){
            return;
        }
        if ((root.left != null && root.right == null)||(root.left == null && root.right != null)||(root.left.key != root.right.key)) {
            result[0] = false;
            return;
        }
        helper(root.left, result);
        helper(root.right,result);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        //t2.right = t4;
        IsSymmetric is = new IsSymmetric();
        boolean result = is.isSymmetric2(t1);
        System.out.println(result);
        System.out.println(is.isSymmetric(t1));
        }
}
