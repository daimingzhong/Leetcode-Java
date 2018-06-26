package leetcode_algorithm.class22_SegmentTree;

/*
https://www.jiuzhang.com/solution/segment-tree-build/

线段树是一棵二叉树，他的每个节点包含了两个额外的属性start和end用于表示该节点所代表的区间。
start和end都是整数，并按照如下的方式赋值:

根节点的 start 和 end 由 build 方法所给出。
对于节点 A 的左儿子，有 start= A.left, end=(A.left + A.right) / 2。
对于节点 A 的右儿子，有 start=(A.left + A.right) / 2 + 1, end=A.right。
如果 start 等于 end, 那么该节点是叶子节点，不再有左右儿子。
实现一个 build 方法，接受 start 和 end 作为参数, 然后构造一个代表区间 [start, end] 的线段树，返回这棵线段树的根。

Segment Tree (a.k.a Interval Tree) is an advanced data structure which can support queries like:

which of these intervals contain a given point 哪个区间内有一个点
which of these points are in a given interval 这些点哪个在一个区间内

See wiki:
Segment Tree
Interval Tree

Example
Given start=0, end=3. The segment tree will be:

               [0,  3]
             /        \
      [0,  1]           [2, 3]
      /     \           /     \
   [0, 0]  [1, 1]     [2, 2]  [3, 3]

Given start=1, end=6. The segment tree will be:

               [1,  6]
             /        \
      [1,  3]           [4,  6]
      /     \           /     \
   [1, 2]  [3,3]     [4, 5]   [6,6]
   /    \           /     \
[1,1]   [2,2]     [4,4]   [5,5]

 */


import leetcode_algorithm.class0.SegmentTreeNode;

public class SegmentTreeBuild_LintCode201 {
    public SegmentTreeNode build(int start, int end) {
        if (start > end) {  // check core case
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);

        if (start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);

            // root.max = Math.max(root.left.max, root.right.max);
        }
        return root;
    }

    public int buildMax(int[] input, int start, int end) {
        // 从头开始，分别建好左右子树。这类父节点依赖子节点的都是这么构造。
        SegmentTreeNode root = new SegmentTreeNode(start, end); // 两个构造函数。max不在构造的时候指定。

        if (start == end) {
            root.max = input[start];
            return root.max;
        }

        int mid = (start + end) / 2;
        int leftMax = buildMax(input, start, mid);
        int rightMax = buildMax(input, mid + 1, end);
        root.max = Math.max(leftMax, rightMax);
        return root.max;
    }

    public int buildSum(int[] input, int start, int end) {
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            return input[start];
        }
        int mid = (start + end) / 2;
        int leftSum = buildSum(input, start, mid);
        int rightSum = buildSum(input, mid + 1, end);
        root.sum = leftSum + rightSum;
        return root.sum;
    }
}

