package leetcode_algorithm.class13_BinarySearchTree;

/*
99. Recover Binary Search Tree

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

https://discuss.leetcode.com/topic/3988/no-fancy-algorithm-just-simple-and-powerful-in-order-traversal/2
 */


import leetcode_algorithm.class0.TreeNode;

public class RecoverBST_99 {
        private TreeNode firstElement = null;
        private TreeNode secondElement = null;
        // The reason for this initialization is to avoid null pointer exception in the first comparison
        // when prevElement has not been initialized
        private TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
        public void recoverTree (TreeNode root){
            // In order traversal to find the two elements
            traverse(root);
            // Swap the values of the two nodes
            int temp = firstElement.val;
            firstElement.val = secondElement.val;
            secondElement.val = temp;
        }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // Start of "do some business",
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }
        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        prevElement = root;
        traverse(root.right);
    }
}