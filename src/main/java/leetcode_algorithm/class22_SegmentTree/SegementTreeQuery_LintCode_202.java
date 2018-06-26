package leetcode_algorithm.class22_SegmentTree;

/*

https://www.lintcode.com/en/problem/segment-tree-query/#

For array [1, 4, 2, 3], the corresponding Segment Tree is:

                  [0, 3, max=4]
                 /             \
          [0,1,max=4]        [2,3,max=3]
          /         \        /         \
   [0,0,max=1] [1,1,max=4] [2,2,max=2], [3,3,max=3]
query(root, 1, 1), return 4

query(root, 1, 2), return 4

query(root, 2, 3), return 3

query(root, 0, 2), return 4


 */

// 遍历一棵有 index 的二叉树。

import leetcode_algorithm.class0.SegmentTreeNode;

public class SegementTreeQuery_LintCode_202 {
    public int query(SegmentTreeNode root, int start, int end) {
        //
        if (root.start == start && root.end == end) {
            return root.max;
        }

        int mid = (root.start + root.end) / 2;
        int leftmax = Integer.MIN_VALUE;
        int rightmax = Integer.MIN_VALUE;

//        // 左子区，修改end的位置。
//        if (start <= mid) {
//            leftmax = query(root.left, start, Math.min(mid, end));
//        }
//
//        // 右子区
//        if (mid < end) { // 分裂 3
//            rightmax = query(root.right, Math.max(mid+1,start), end);
//        }
//
//         // 如果是rangeSum，就让左右的和相加。
//        return Math.max(leftmax, rightmax);

        int res = Integer.MIN_VALUE;
        if (start <= mid && end <= mid){
            res = query(root.left, start, end);
        }

        if (start >= mid && end >= mid) {
            res = query(root.right, start, end);
        }

        if (start <= mid && end > mid) {
            res = Math.max(query(root.left, start, mid), query(root.right, mid + 1, end));
        }
        return res;
    }

    // 给一棵树的根结点，和 起始结束结束位置。
    public int getSum(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        // 通过修改左右边界，使得范围正好fit
        int mid = (root.start + root.end) / 2;
        int leftSum = getSum(root.left, start, mid);
        int rightSum = getSum(root.right, mid + 1, end);
        root.sum = leftSum + rightSum;
        return root.sum;
    }

}
