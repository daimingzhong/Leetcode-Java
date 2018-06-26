package leetcode_basic.class22_PracticeIII;


import leetcode_basic.class0.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dai on 2017/1/1.
 * 一条线上是否有解。
         5
      /    \
     2      11
          /  \
        6   14
      /
    3

 If target = 17, There exists a path 11 + 6, the sum of the path is target.
 If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.


        1
      /  \
     2    6
    / \
   9  5

 */
public class BinaryTreePathSumToTarget {
    public boolean exist(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        List<TreeNode> path = new ArrayList<>();
        return helper(root, path, sum);
    }

    private boolean helper(TreeNode root, List<TreeNode> path, int sum) {
        path.add(root);
        int tmp = 0;
        for(int i = path.size() - 1; i >= 0; i--) {
            tmp += path.get(i).key;
            if(tmp == sum) {
                return true;
            }
        }
        if (root.left != null && helper(root.left, path, sum)) {
            return true;
        }
        if (root.right != null && helper(root.right, path, sum)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public boolean exist2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Set<Integer> prefixSums = new HashSet<>();
        prefixSums.add(0);
        return helper2(root, prefixSums, 0, sum);
    }

    private boolean helper2(TreeNode root, Set<Integer> prefixSums, int prevSum, int sum) {
        prevSum += root.key;
        if (prefixSums.contains(prevSum - sum)) {
            return true;
        }
        boolean needRemove = prefixSums.add(prevSum);
        if (root.left != null && helper2(root.left, prefixSums, prevSum, sum)) {
            return true;
        }
        if (root.right != null && helper2(root.right, prefixSums, prevSum, sum)) {
            return true;
        }
        if (needRemove) {
            prefixSums.remove(prevSum);
        }
        return false;
    }



    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(9);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(6);
        t1.left = t2;
        t1.right = t5;
        t2.left = t3;
        t2.right = t4;
        BinaryTreePathSumToTarget binaryTreePathSumToTarget = new BinaryTreePathSumToTarget();
        boolean res = binaryTreePathSumToTarget.exist2(t1, 10);
        System.out.println(res);
    }
}
