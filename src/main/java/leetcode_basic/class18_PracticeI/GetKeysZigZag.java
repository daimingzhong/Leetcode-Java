package leetcode_basic.class18_PracticeI;


import leetcode_basic.class0.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 交错输出每一行
 *          2
 *        /  \
 *      1     5
 *    /  \
 *  6    7
 *
 *  output: [2,1,5,7,6]
 */

public class GetKeysZigZag {
    public List<Integer> zigZag(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        int layer = 0;
        if (root == null) {
            return result;
        }
        while(!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (layer == 0) {
                    TreeNode tmp = deque.pollLast();
                    result.add(tmp.key);
                    if (tmp.right != null) {
                        deque.offerFirst(tmp.right);
                    }
                    if (tmp.left != null) {
                        deque.offerFirst(tmp.left);
                    }
                }
                else {
                    TreeNode tmp = deque.pollFirst();
                    result.add(tmp.key);
                    if (tmp.left != null) {
                        deque.offerLast(tmp.left);
                    }
                    if (tmp.right != null) {
                        deque.offerLast(tmp.right);
                    }
                }
            }
            layer = 1 - layer;
        }
        return result;
    }

    public static void main (String[] args) {
        GetKeysZigZag gk = new GetKeysZigZag();
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        List result = gk.zigZag(null);
        for (Object i : result) {
            System.out.println(i);
        }
    }
}
