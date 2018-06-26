package leetcode_algorithm.class0;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dai on 8/9/17.
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /*
    when n = 6

                1
              /  \
             2   3
            / |  /
           4  5 n
     */
    public TreeNode newTree(int n) {
        TreeNode dummy = new TreeNode(1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(dummy);
        for (int i = 1; i <= n / 2; i++) {
            TreeNode cur = queue.poll();
            TreeNode left = new TreeNode(2 * i);
            cur.left = left;
            queue.add(left);
            // i == 6, then append to 6 only.
            if (i < n/2 || n % 2 != 0) {
                TreeNode right = new TreeNode(2 * i + 1);
                cur.right = right;
                queue.add(right);
            }

        }
        return dummy;
    }

    public void printTreeLayerByLayer(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        System.out.println(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    System.out.print(cur.left.val + " ");
                } else {
                    System.out.print("# ");
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    System.out.print(cur.right.val + " ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode tree = treeNode.newTree(6);
        treeNode.printTreeLayerByLayer(tree);
    }
}
