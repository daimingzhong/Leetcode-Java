package leetcode_basic.class4_BinaryTree;

import leetcode_basic.class0.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *       5

 /    \

 3        8

 /   \        \

 1      4        11

 In-order traversal is [1, 3, 4, 5, 8, 11]
 *          2
 *        /  \
 *      1     5
 *    /  \
 *  null 7
 *    LinkedList stack  2 1 (-1) 7 (-7)  5
 *    ArrayList  inorder   1 7 2 5
 *
 *    先探索左边，1 左边探索完了，右边赋值了，1就黑了。
 */

public class InOrderTraverse {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>(); // 只有LinkedList实现了deque，arraylist没有。
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offer(cur);
                cur = cur.left;
             } else {
                cur = stack.poll();// return value of pollFirst 如果一个函数有return value，调的时候没有写，会出错吗。
                inorder.add(cur.key);
                cur = cur.right;
            }
        }
        return inorder;
    }

    public List<Integer> inOrder2(TreeNode root, List<Integer> inOrderResult) {
        // 往上跳，是由当前return结束，实现的。类比扫地机器人。这里要多一个return back。
        if (root != null) {
            inOrder2(root.left, inOrderResult);
            inOrderResult.add(root.key);
            inOrder2(root.right, inOrderResult);
        }
        return inOrderResult; //每次到底都会返回一次值
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        InOrderTraverse in = new InOrderTraverse();

        List<Integer> inorderResult = new ArrayList<>();
        List result = in.inOrder(t1);
        List result2 = in.inOrder2(t1,inorderResult);
        for (Object i : result) {
            System.out.println(i);
        }

        List<?extends List<Integer>> ls = new ArrayList<ArrayList<Integer>>();
    }
}