package leetcode_algorithm.class4_BinaryTree;

import leetcode_algorithm.class0.TreeNode;

/*
129. Sum Root to Leaf Numbers

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

if go to the leaf, add the value, and go back

这个题的本质是，先遍历左节点，再取值，再遍历右节点。所以是in-order traverse.
 */
public class SumRootToLeafNumbers_129 {

    private int result = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        helper(root, 0, 0);
        return result;
    }

    private void helper(TreeNode root, int layer, int val) {
        if(root.left == null && root.right == null) {
            result += (val + root.val); // 怎么可能写出 result += result + val????
        }
        if(root.left != null) {
            helper(root.left, layer + 1, (val + root.val)*10); // 这里要先算好。
        }
        if(root.right != null) {
            helper(root.right, layer + 1, (val + root.val)*10);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.println(new SumRootToLeafNumbers_129().sumNumbers(t1));
    }
}