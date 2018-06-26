package leetcode_basic.class98;


import leetcode_basic.class0.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Dai on 2017/1/1.
 * 判断queue是否为空，应该是queue.size()。而不是判断null
 */
public class IdenticalBinaryTree {
    public boolean isIdentical2(TreeNode one, TreeNode two) {
        Deque<TreeNode> queueOne = new LinkedList<>();
        Deque<TreeNode> queueTwo = new LinkedList<>();
        if (one == null || two == null) {
            if (one == null && two == null) {
                return true;
            }
            return  false;
        }
        queueOne.offer(one);
        queueTwo.offer(two);
        // Queue里有add offer poll peek. Stack 里有push pop peek
        //add 和 offer 的区别 作为List使用时,一般采用add / get方法来 压入/获取对象
        // 作为Queue使用时,才会采用 offer/poll/take等方法
        while(queueOne.size()!= 0 && queueTwo.size() != 0) {
            TreeNode rootOne = queueOne.poll();
            TreeNode rootTwo = queueTwo.poll();
            if (rootOne.key != rootTwo.key) {
                return false;
            }
            if (rootOne.left != null) {
                queueOne.offer(rootOne.left);
            }
            if (rootTwo.left != null) {
                queueTwo.offer(rootTwo.left);
            }
            if (rootOne.right != null) {
                queueOne.offer(rootOne.right);
            }
            if (rootTwo.right != null) {
                queueTwo.offer(rootTwo.right);
            }
        }
        if (queueOne.size() != 0 || queueTwo.size() != 0) {
            return false;
        }
        return true;
    }

    public boolean isIdentical(TreeNode one, TreeNode two) {
        if (one == null || two == null) {
            if (one == null && two == null) {
                return true;
            }
            return  false;
        }
        if (one.key != two.key) {
            return false;
        }
        return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
    }
        public static void main(String[] args) {
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(5);
        /*
                6
              /  \
            4     7
           / \
          1  5
         */
        t1.left = t2;
        //t1.right = t3;
        //t2.left  = t4;
        //t2.right = t5;
        IdenticalBinaryTree ib = new IdenticalBinaryTree();
        boolean result = ib.isIdentical(t1,t1);
        System.out.println(result);
    }
}
