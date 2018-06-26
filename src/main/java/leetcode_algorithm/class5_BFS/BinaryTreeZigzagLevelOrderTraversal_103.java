package leetcode_algorithm.class5_BFS;

import leetcode_algorithm.class0.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

103. Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

arraylist里放了一个linkedlist。在存linkedlist时，可以从头存。

odd -- 奇数  even 偶数

                 3           0
               /   \
              9    20         1
             / \  /  \
            2  6 15   7       2

insert 3 to queue
when the layer number is odd, like 1, add to last, else add to the front.
so the queue in layer 1 is 9, 20
in layer 2 is 7, 15.

int the queue, the sequence is still the same,
装进queue的过程，一直是顺序的。比如 3 9 20 2 6
只是构造当前解的过程，ArrayList，9，20是从右往左加的。

 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while(!q.isEmpty()){
            LinkedList<Integer> cur = new LinkedList<>();
            for(int i = 0; i < q.size(); i++){
                root = q.poll();
//                (level % 2 == 0) ? (cur.addFirst(root.val)) : (cur.add(root.val)); 不可以这么写因为三目运算符一定要有返回值。
                if(root.left != null)
                    q.offer(root.left);
                if(root.right != null)
                    q.offer(root.right);
                if(level % 2 != 0){
                    cur.add(root.val);
                }else{
                    cur.addFirst(root.val);
                }
            }
            result.add(cur);
            level++;
        }
        return result;
    }
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal_103 bt = new BinaryTreeZigzagLevelOrderTraversal_103();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t4.right = t5;
        bt.zigzagLevelOrder(t1);
    }
}
