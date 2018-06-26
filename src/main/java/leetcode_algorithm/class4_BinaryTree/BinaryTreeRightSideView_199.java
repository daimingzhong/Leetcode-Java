package leetcode_algorithm.class4_BinaryTree;

/*
199. Binary Tree Right Side View

Given a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].


bfs, while queue is not empty. for++;

这个题用List不是很好，因为删头的操作代价高。
可以用Queue。在while里判断，queue的size是1的时候，就加到结果里去。

或者用dfs，把层数信息存进去，存到map里。
 */


import leetcode_algorithm.class0.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        List<TreeNode> queue = new ArrayList<>();
        helper(root, queue, result);
        return result;
    }

    private void helper(TreeNode root, List<TreeNode> queue, List<Integer> result) {
        queue.add(root);
        while (!queue.isEmpty()) {
            result.add(queue.get(queue.size() - 1).val);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.get(0);
                queue.remove(0);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView_199 bt = new BinaryTreeRightSideView_199();
        bt.rightSideView(new TreeNode(1));
    }
}
