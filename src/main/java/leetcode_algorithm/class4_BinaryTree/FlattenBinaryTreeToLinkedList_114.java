package leetcode_algorithm.class4_BinaryTree;


import leetcode_algorithm.class0.TreeNode;

/*
114. Flatten Binary Tree to Linked List

Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

1. 左 + 右。右放到左边的最大的下面。root的左变成右。
2. only 右。没事
3. only 左。把左边放到右边。

找prev:
1. 左+右/only右，走右。
2. only左，走左。
3. 左右都是null，返回。

注意，本身也是个递归。从root开始，一直处理root.right.
一遍ac，炸了。

 */
public class FlattenBinaryTreeToLinkedList_114 {
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return;
        }
        if(root.left != null && root.right != null) {
            TreeNode tmp = pre(root.left);
            tmp.right = root.right;
            root.right = root.left;
            root.left = null;
        } else if (root.left != null) {
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }

    private TreeNode pre(TreeNode root) {
        if(root.left == null && root.right == null) {
            return root;
        }
        if(root.right != null) {
            return pre(root.right);
        } else {
            return pre(root.left);
        }
    }


    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList_114 fb = new FlattenBinaryTreeToLinkedList_114();
        TreeNode t1 = new TreeNode(1);
        fb.flatten(t1);

    }
}


class Method2{
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root, null);
    }

    public TreeNode flatten(TreeNode root, TreeNode next) {
        if (root == null) {
            return next;
        }
        next = flatten(root.right, next);
        next = flatten(root.left, next);
        root.right = next;
        root.left = null;
        return root;
    }
}

class Method3{
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}