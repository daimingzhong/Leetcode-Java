package leetcode_basic.class4_BinaryTree;


import leetcode_basic.class0.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *     5
    /    \
   3        8
 /   \        \
 1      4        11

 Pre-order traversal is [5, 3, 1, 4, 8, 11]
 *          2
 *        /  \
 *      1     5
 *    /  \
 *  null 7
 *
 *
 *   preOrder 2 1 7 5
 */
public class PreOrderTraverse {
    public List<Integer> preOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> preOrder = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                preOrder.add(cur.key);
                stack.offer(cur);
                cur = cur.left;
            } else {
                cur = stack.poll();
                cur = cur.right;
            }
        }
        return preOrder;
    }

    public void preOrder2(TreeNode input, List<Integer> result) {
        if (input != null) {
            result.add(input.key);
            preOrder2(input.left, result);
            preOrder2(input.right,result);
        }
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        PreOrderTraverse in = new PreOrderTraverse();
        List<Integer> result = in.preOrder(t1);
        // List 不写尖括号，默认List <Object>
        List<Integer> result2 = new ArrayList<>();
        in.preOrder2(t1, result2);

        for (Integer i : result) {
            System.out.println(i);
        }
    }
}