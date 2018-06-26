package leetcode_basic.class4_BinaryTree;

import leetcode_basic.class0.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


/**
 * 中序遍历
 */
public class GetRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> inOrder = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.offerFirst(root);
                root = root.left;
            }
            else {
                root = stack.pollFirst();
                if (root.key <= max && root.key >= min) {
                    inOrder.add(root.key);
                }
                root = root.right;
            }
        }
        return  inOrder;
    }
    public List<Integer> getRange2(TreeNode root, int min, int max) {
        List<Integer> list = new ArrayList<>();
        getRange2(root, min, max, list);
        return list;
    }
    public void getRange2(TreeNode root, int min, int max, List<Integer> list) {
        if (root == null) {
            return ;
        }
        // 左根右
        if (root.key > min) {
            getRange2(root.left, min, max, list);
        }
        // 根
        if (root.key >= min && root.key <= max) {
            list.add(root.key);
        }
        // 右
        if (root.key < max) {
            getRange2(root.right, min, max, list);
        }
    }


        public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(0);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        GetRange gt = new GetRange();
        List<Integer> result = gt.getRange2(t1, 1, 5);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
