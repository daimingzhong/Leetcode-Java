package leetcode_basic.class20_Mid;


import leetcode_basic.class0.TreeNode;

public class MaxPathSubtree {
    public int maxPathSum (TreeNode root) {
        int max[] = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode node, int[] result) {
        // base case
        if (node == null) {
            return 0;
        }
        //先到底，再往上，每一步有一个返回值。这个值用来指导当前层的行为。
        // 对这道题，就是返回一个当前路径的最大值。
        // 对bst的题，
        int left = helper(node.left, result);
        int right = helper(node.right, result);    // step1
        if (node.left != null && node.right != null) {	// Step2
            result[0] = Math.max(result[0], left + right + node.key);
            return Math.max(left, right) + node.key;	// Step 3a
        }

        return node.left == null ? right + node.key  :   left + node.key;   // Step 3b
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
        MaxPathSubtree maxPath = new MaxPathSubtree();
        //System.out.println(t1.key);
        System.out.println(maxPath.maxPathSum(t1));
    }
}
