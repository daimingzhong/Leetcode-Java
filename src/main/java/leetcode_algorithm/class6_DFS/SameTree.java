package leetcode_algorithm.class6_DFS;


/*
100. Same Tree

Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

 */


import leetcode_algorithm.class0.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 对于递归来说，这不是base case。p q 相同之所以不能写，是因为还会下去，不能在这里return。
        // 向下传的是左右子树，向上是boolean都没错。错的是，不可以有无条件返回。最后一步其实是p,q值不相等。
//        if(p == null && q == null || (p!= null && q != null && p.val == q.val)) {
//            return true;
//        }
//        else {
//            return false;
//        }
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false; // 这个写在递归后面，返回必须有返回的条件。
    }
}