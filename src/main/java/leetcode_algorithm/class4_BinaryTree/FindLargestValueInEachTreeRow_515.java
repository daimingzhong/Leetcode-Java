package leetcode_algorithm.class4_BinaryTree;

/*

515. Find Largest Value in Each Tree Row

You need to find the largest value in each row of a binary tree.

Example:
Input:

          1
         / \
        3   2
       / \   \
      5   3   9

Output: [1, 3, 9]


queue

size 1, 1

size 2, 3  2

size 3, 5  3  9

for each layer, keep a max value. and return while the layer has been totally traversed.
use a counter for the size of each layer.

 */



import leetcode_algorithm.class0.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.val > max){
                    max = cur.val;
                }
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
