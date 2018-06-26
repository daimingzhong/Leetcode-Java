package leetcode_algorithm.class4_BinaryTree;
/*

257. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

               1
             /   \
            2     3
           /  \
           4   5
All root-to-leaf paths are:

["1->2->5", "1->3"]

back tracking.

方法1：
用stringbuilder。
注意的是，不一定是删除3个元素。 ->1. 如果是 ->101，要删除五个元素。所以要记录长度。


方法2：
用ArrayList
这样可以按照元素个数来删。

方法3：
用String
这样的缺点是空间开销大一些。
 */


import leetcode_algorithm.class0.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res, new StringBuilder());
        return res;
    }

    private void helper(TreeNode root, List<String> res, StringBuilder cur) {
        if(root == null) {
            return;
        }
        if (root.left == null && root.right == null) { // we add it when it is the leaf node.
            int len = cur.length();
            cur.append(root.val);
            res.add(new String(cur));
            cur.setLength(len);
            return;
        }
        if(root.left != null) {
            int len = cur.length();
            cur.append(root.val);
            cur.append("->");
            helper(root.left, res, cur); // because the left help us when to return, so we need to judge
            cur.setLength(len);
        }
        if(root.right != null) {
            int len = cur.length();
            cur.append(root.val);
            cur.append("->");
            helper(root.right, res, cur);  // when we want to add the right node, make sure, the right exists.
            cur.setLength(len);
        }
    }

    public void DFS(TreeNode root, String solution, ArrayList<String> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) res.add(solution + root.val);
        DFS(root.left, solution + root.val + "->", res);
        DFS(root.right, solution + root.val + "->", res);
    }

    public List<String> helper(List<String> result, String path, TreeNode root) {
        if (root.left == null && root.right == null) {
            path += root.val;
            result.add(new String(path));
        }
        path = path + root.val + "->";
        if (root.left != null)
            helper(result, path, root.left);
        if (root.right != null)
            helper(result, path, root.right);
        return result;
    }

    public static void main(String[] args) {
        BinaryTreePath_257 bt = new BinaryTreePath_257();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2; t1.right = t3; t2.left = t4; t2.right = t5;
        bt.binaryTreePaths(t1);
    }
}