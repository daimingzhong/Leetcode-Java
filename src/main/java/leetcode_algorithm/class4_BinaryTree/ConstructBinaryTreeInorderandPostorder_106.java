package leetcode_algorithm.class4_BinaryTree;

import leetcode_algorithm.class0.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
https://www.youtube.com/watch?v=t7A7tB9pcDU
 */

class ConstructBinaryTreeInorderandPostorder_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        // 保存中序遍历根节点索引
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder, map);
    }

    private TreeNode helper(int inStart, int inEnd, int postStart, int postEnd, int[] inorder, int[] postorder, Map<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) return null;
        // postorder的最后一个元素一定是二叉树的根节点
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(postorder[postEnd]);
        root.left = helper(inStart, inRoot - 1, postStart, postStart + (inRoot - inStart - 1), inorder, postorder, map);
        root.right = helper(inRoot + 1, inEnd, postStart + (inRoot - inStart), postEnd - 1, inorder, postorder, map);
        return root;
    }
}

