package leetcode_algorithm.class2_BinarySearch;

import leetcode_algorithm.class0.TreeNode;

/*

108. Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

     7
   /   \
  5     9
 / \   / \
1  6 8   10

*/


public class ConvertSortedArrayToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (end + start)/2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = helper(nums, start, mid - 1);
        midNode.right = helper(nums, mid + 1, end);
        return midNode;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBST_108 ca = new ConvertSortedArrayToBST_108();
        TreeNode root = ca.sortedArrayToBST(new int[]{1,5,6,7,8,9,10});
    }
}
