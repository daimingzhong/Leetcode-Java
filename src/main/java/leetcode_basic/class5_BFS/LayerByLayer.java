package leetcode_basic.class5_BFS;


import leetcode_basic.class0.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Dai on 2016/12/1.
       5
     / \
   3   8
  / \
 1   4
 the result is [ [5], [3, 8], [1, 4, 11] ]
 一次遍历一整行，用for控制queue

 */
public class LayerByLayer {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();// 为什么内层可以变成List
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode curNode = queue.poll();
                cur.add(curNode.key);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            result.add(cur);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        LayerByLayer lb = new LayerByLayer();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result = lb.layerByLayer(t1);
        for (List<Integer> a : result) {
            for (Integer b : a) {
                System.out.println(b);
            }
        }
    }
}
