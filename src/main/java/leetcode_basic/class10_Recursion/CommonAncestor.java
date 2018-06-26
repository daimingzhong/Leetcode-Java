package leetcode_basic.class10_Recursion;


import leetcode_basic.class0.TreeNode;

public class CommonAncestor {
    public TreeNode commonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        if (root == a || root ==b) {
                return root;
        }
        //为什么这里要写left right
        TreeNode left = commonAncestor(root.left , a, b);
        TreeNode right = commonAncestor(root.right, a, b);
        //对当前节点的操作：
        if (left != null && right != null) { //左右都包含，返回root
            return root;
        }
        //这里如果都不等，怎么办？
        return (left != null)? left : right ; //只包含其中一个，则返回其中一个
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
        CommonAncestor check = new CommonAncestor();
        //System.out.println(t1.key);
        System.out.println(check.commonAncestor(t1, t4, t5).key);
    }
}
/*
           6
         / \
        4   7
      /  \
     1   5
*/
