package leetcode_algorithm.class5_BFS;

/*

https://leetcode.com/problems/binary-tree-level-order-traversal/description/

102. Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

循环写法：
关键， while套for，因为第二个要精确控制循环步数。第一个是当前的size，第二个是之前的size。
第一层也可以用for或者while。

 */

import leetcode_algorithm.class0.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        List<Integer> list = new ArrayList<>(); 不能写在这儿是因为每次都要清空list。
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {//for(int i = 0; i < queue.size(); i++) { 这里不能这么写， 是因为下面不断在加。
                TreeNode curNode = queue.poll();
                list.add(curNode.val);
                if(curNode.left!= null) {
                    queue.add(curNode.left); // 这里不是root.left!!!! 坑爹呢，掉到死循环里。
                }
                if(curNode.right!= null) {
                    queue.add(curNode.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        queue.add(root);
        for(int i = 0; i <queue.size(); i++) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                TreeNode curNode = queue.poll();
                list.add(curNode.val);
                if(curNode.left!= null) {
                    queue.add(curNode.left);
                }
                if(curNode.right!= null) {
                    queue.add(curNode.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) { //dfs
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) { // 新建一个
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val); //加到对应的层高的res上。
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.right = n5;
        levelOrder(n1);
    }
}



