package leetcode_basic.class4_BinaryTree;

import leetcode_basic.class0.TreeNode;

import java.util.*;

/**
         5
      /    \
    3        8
  /   \        \
 1      4      11

 Post-order traversal is [1, 4, 3, 11, 8, 5]
 */
public class PostOrderTraverse {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // result
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return result;
        }
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            result.add(cur.key);
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
    }
        Collections.reverse(result);
        return  result;
    }
    public List<Integer> postOrder2(TreeNode root, List<Integer> result) {
        if (root != null) {
            postOrder2(root.left, result);
            postOrder2(root.right, result);
            result.add(root.key);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        PostOrderTraverse ps = new PostOrderTraverse();
        List<Integer> result = ps.postOrder(t1);
        List<Integer> result2 = new ArrayList<>();
        result2 = ps.postOrder2(t1,new ArrayList<>());
        for (Integer i : result2) {
            System.out.println(i);
        }
    }
}
