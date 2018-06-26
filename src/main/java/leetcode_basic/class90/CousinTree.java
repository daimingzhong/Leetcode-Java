package leetcode_basic.class90;


import leetcode_basic.class0.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dai on 2017/1/4.
 Check if two nodes are cousins in a Binary Tree
 Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes are cousins of each other or not.
 Two nodes are cousins of each other if they are at same level and have different parents.
 Example
       6
    /   \
   3     5
  / \   / \
 7   8 1   2


 7 and 1, result is TRUE.
 3 and 5, result is FALSE.
 7 and 5, result is FALSE.
 */
// 同一批次被发现，并且不是来自同一个father，bfs
// Two steps, 1. check the depth. 2. If they have the same father.
// Time complexity: O(n);
// use bfs is easier
// we assume that two nodes are in the tree

public class CousinTree {
    public boolean cousinNode(TreeNode root, TreeNode one, TreeNode two) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> childQueue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            boolean result = helper(queue, childQueue, one, two);
            if (result) {
                return true;
            }
            queue = childQueue;
        }
        return false;
    }

    private boolean helper(Queue<TreeNode> queue, Queue<TreeNode> childQueue,TreeNode one, TreeNode two) {
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                childQueue.offer(cur.left);
            }
            if (cur.right != null) {
                childQueue.offer(cur.right);
            }
            if ((cur.left == one && cur.right == two)|| (cur.left == two && cur.right == one)) {
                return false;
            }
            if (cur.left == one || cur.right == two || cur.right == one || cur.right == two) {
                count++;
            }
            if (count == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean cousinNode2 (TreeNode root, TreeNode one, TreeNode two) {
        int[] dep = {0};
        int depthOne = depth(root, one);// solve the depth first
        int depthTwo = depth(root, two);
        boolean flag = father(root, one, two);// see if they have the same father
        if (depthOne == depthTwo && flag) {
            return true;
        }
        else {
            return false;
        }
    }

    public int depth (TreeNode root, TreeNode treeNode) {
        // 深度本身也是要用bfs做的。
        if (root == treeNode) {
            return 1;
        }
        return depth(root.left, treeNode) + 1;
    }

    // bfs is easier here.
    public boolean father(TreeNode root, TreeNode one, TreeNode two) {
        // return true, if they have the same father
        if (root == null) {
            return false;
        }
        if (root.left == one && root.right == two || root.right == two && root.left == one) {
            return true;
        }
        return father(root.left, one, two) || father(root.right, one, two);
    }

    public static void main(String[] args) {
        CousinTree ct = new CousinTree();
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left  = t4;
        t2.right = t5;
        t3.right = t6;
        boolean result =  ct.cousinNode(t1, t4, t6);
        System.out.print(result);
    }
}

/*
                6
              /  \
            4     7
           / \     \
          1  5     9
*/
