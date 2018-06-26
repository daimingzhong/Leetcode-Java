package leetcode_basic.class21_PracticeII;


import leetcode_basic.class0.TreeNode;

/**
 * Created by Dai on 2016/12/25.
 * Insert a key in a binary search tree if the binary search tree does not already contain the key.
 * Return the root of the binary search tree.
 * Assumptions
 * There are no duplicate keys in the binary search tree
 * If the key is already existed in the binary search tree, you do not need to do anything
 */
public class InsertInBinarySearchTree {
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (root.key == key) {
            return root;
        }
        if  (key > root.key) {
            if (root.right == null) {
                root.right = new TreeNode(key);
            }
            else {
                insert(root.right, key);
            }
        }
        if (key < root.key) {
            if (root.left == null) {
                root.left = new TreeNode(key);
            }
            else {
                insert(root.left, key);
            }
        }
        return root;
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
        InsertInBinarySearchTree ii = new InsertInBinarySearchTree();
        ii.insert(t1,11);
        System.out.println(t1.key);
    }
}

