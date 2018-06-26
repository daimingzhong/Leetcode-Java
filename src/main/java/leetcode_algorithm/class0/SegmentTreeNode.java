package leetcode_algorithm.class0;

/*
segment
record its left and right position.
*/

public class SegmentTreeNode {
    public int start;
    public int end;
    public int max;
    public int sum;

    public SegmentTreeNode left;
    public SegmentTreeNode right;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
    }
}
