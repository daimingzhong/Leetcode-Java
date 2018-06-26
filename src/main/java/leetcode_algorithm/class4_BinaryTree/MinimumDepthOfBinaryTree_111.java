package leetcode_algorithm.class4_BinaryTree;



import leetcode_algorithm.class0.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest
 path from the root node down to the nearest leaf node.

it's easy to think. If a node has both left and right child, it means that the node has both left child tree and right child tree, so we just recursively find the min height of subtree. However, if a node has only one whichever subtree, let's say left subtree, what we should do? Can we still find the min between the left subtree and a null? Of course not, so we should find the height of the left subtree itself, so we use max in this condition.

you can draw a picture to figure this out

 */
public class MinimumDepthOfBinaryTree_111 {
    public int minDepth(TreeNode root) {
        // wrong. refer to print layer by layer. method 4.
        // while + for
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        int result = 1;
        int curCount = 0;
        while(count != 0) {
            TreeNode head = queue.poll();
            if(root.left == null && root.right == null) {
                break;
            }
            if(head.left != null) {
                queue.offer(head.left);
                curCount++;
            }
            if(head.right != null) {
                queue.offer(head.right);
                curCount++;
            }
            result++;
            count = curCount;
            curCount = 0;
        }
        return  result;
    }

    public int minDepth2(TreeNode root) { // this is dfs
        if (root == null)
            return 0;
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    public int minDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }

    public int minDepth4(TreeNode root) { // bfs
        if(root == null) {
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            // for each level
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}