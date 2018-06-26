package leetcode_algorithm.class4_BinaryTree;

import leetcode_algorithm.class0.TreeNode;
import leetcode_algorithm.class2_BinarySearch.ConvertSortedArrayToBST_108;

/*

http://blog.devtang.com/2015/06/16/talk-about-tech-interview/
https://discuss.leetcode.com/topic/16039/straightforward-dfs-recursive-iterative-bfs-solutions

226. Invert Binary Tree

Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9

to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

     7
   /   \
  5     9
 / \   / \
1  6 8   10


Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew)
but you can’t invert a binary tree on a whiteboard so fuck off.、


pass right, and return as cur's left. but save left beforehand.
then pass tmp(left) return as right.


invert a binary tree is the same as invert an array.
the only diff is there is a return value.

 */

public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        // root.left 和 tmp指向同一个地方，后来left被改掉，tmp也会被改。
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        // get both return value, and then swap.
        if (root == null) {
            return null;
        }
        root.left = invertTree2(root.left);
        root.right = invertTree2(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBST_108 ca = new ConvertSortedArrayToBST_108();
        TreeNode root = ca.sortedArrayToBST(new int[]{5,7,9});
        InvertBinaryTree_226 ib = new InvertBinaryTree_226();
        ib.invertTree(root);
    }
}
