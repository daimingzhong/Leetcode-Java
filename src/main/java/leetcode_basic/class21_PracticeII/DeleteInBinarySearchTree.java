package leetcode_basic.class21_PracticeII;


import leetcode_basic.class0.TreeNode;

/**
 * Created by Dai on 2016/12/25.
 * Delete the target key K in the given binary search tree if the binary search tree contains K.
 * Return the root of the binary search tree.
 * Find your own way to delete the node from the binary search tree,
 * after deletion the binary search tree's property should be maintained.
 */

public class DeleteInBinarySearchTree {
    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.key == key) {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            else if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            }
            else  {
                TreeNode newNode = deleteNode(root,key);
                newNode.left = root.left;
                newNode.right = root.right;
                return newNode;
            }
        }
        if (root.key > key) {
            root.left = delete(root.left, key);
        }
        else if(root.key < key){
            root.right = delete(root.right, key);
        }
        return root;
    }

    private TreeNode deleteNode(TreeNode root, int key) {
        TreeNode right = root.right;
        while (right.left.left != null) {
            right = right.left;
        }
        TreeNode newNode = right.left; //right之后会被修改，所以先保留
        right.left = right.left.right;
        return newNode;
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
        DeleteInBinarySearchTree di = new DeleteInBinarySearchTree();
        TreeNode newRoot = di.delete(t1,6);
        System.out.println(newRoot.key);
    }
}
