package leetcode_basic.class21_PracticeII;


import leetcode_basic.class0.TreeNode;

/**
 * Created by Dai on 2016/12/25.
 * Find the target key K in the given binary search tree
 * return the node that contains the key if K is found, otherwise return null.
 * Assumptions
 * There are no duplicate keys in the binary search tree
 */
public class SearchInBinarySearchTree {
    public TreeNode search(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key == root.key) {
            return root;
        }
        else if (key > root.key){
            return search(root.right, key);
        }
        else {
            return search(root.left, key);
        }
    }
}