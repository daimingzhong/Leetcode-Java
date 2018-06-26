package leetcode_algorithm.class13_BinarySearchTree;

/*

450. Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST.
Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7


从下往上，用返回值判断。返回值就是当前的left / right.
three steps:
1. need what, cur node, key
2. do what, find the mini one, update with cur.left / cur.right
3. return what, the valid next node.

for cur node. three cases
1. too big, update cur.right
2. too small, update cur.left
3. just ok. then

There are four cases.
1. if is leaf node, no left or right node. cur
2. has only left. return as cur.right
3. has only right, return as cur.left.
4. has left & right, find the min one, and update right subtree.


有三种情况

1. 当前点 > key, 左子树有要找的点，delete(root.left, key)  返回root
2. 当前点 < key, delete(root.right, key) 返回root
3. 当前点 == key
   3.1 当前点没有左 or 右 节点，返回单个孩子。
   3.2 当前点有左右孩子，找右边里最小的，同时对右子树，实行删掉刚刚最小值的操作。
       右边最小的，保证没有左子树，变成了情况1。

 */


import leetcode_algorithm.class0.TreeNode;

public class DeleteNodeInBST_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    // 伪递归
    private TreeNode findMin2(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return findMin2(node.left);
    }

    private TreeNode findMin(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}
