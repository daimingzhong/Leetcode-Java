package leetcode_basic.class20_Mid;


import leetcode_basic.class0.TreeNode;

public class MaxLeafWay {
    private int maxValue = Integer.MIN_VALUE;
    public int maxLeafWay (TreeNode root) {
        helper(root);
        return maxValue;
    }
    private int helper(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return treeNode.key;
        }
        else {
            int left = Math.max(helper(treeNode.left), helper(treeNode.left) + treeNode.key);
            int right = Math.max (helper(treeNode.right), helper(treeNode.right)+ treeNode.key);
            int all =  helper(treeNode.left) + treeNode.key + helper(treeNode.right);
            int max =  Math.max (left, right);
            int maxall = Math.max (max, all);
            if (maxall > maxValue) {
                maxValue = maxall ;
            }
            return max;
        }
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
        MaxLeafWay maxPath = new MaxLeafWay();
        //System.out.println(t1.key);
        System.out.println(maxPath.maxLeafWay(t1));
    }

}
