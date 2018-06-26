package leetcode_algorithm.class4_BinaryTree;

/*
404. Sum of Left Leaves

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree,
with values 9 and 15 respectively. Return 24.



            3

         9     20


return value of left node sum, and total sum. in the case that, this is the left node to its father

the value passed to function, and the value return of the function is still different. really???
if the value passed to the function is from the bottom layer, then they are similar.


be careful about the definition of leaf node.
meaning its left & right leaf is null. so that we return. pass value from bottom up.

 */


import leetcode_algorithm.class0.TreeNode;

public class SumOfLeftLeaves_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            // base case, left node is a leaf node.
            return root.left.val + helper(root.right);
        }
        return helper(root.left) + helper(root.right);
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int ans = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) {
                ans += root.left.val;
            }
            else {
                ans += sumOfLeftLeaves(root.left);
            }
        }
        ans += sumOfLeftLeaves(root.right);

        return ans;
    }
}
