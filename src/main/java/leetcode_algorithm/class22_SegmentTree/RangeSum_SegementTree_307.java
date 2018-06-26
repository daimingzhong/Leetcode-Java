package leetcode_algorithm.class22_SegmentTree;

/*
https://www.youtube.com/watch?v=S0Bf9jpgHmQ
https://github.com/ctfu/Leetcode/blob/master/algorithm/rangeSumQuery-mutable.java 
 */

public class RangeSum_SegementTree_307 {
    
    private int[] nums;
    private int[] tree;

    public RangeSum_SegementTree_307(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length * 2];
        buildTree(nums);
    }

    public void buildTree(int[] nums) {
        for (int i = nums.length, j = 0; j < nums.length; i++, j++) {
            tree[i] = nums[j];
        }
        for (int i = nums.length - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    /*
    保证 tree[i] = tree[2i] + tree[2i + 1]
    0   1 2 3 || 4 5 6 7
    13 10 3 7 || 1 2 3 4

    e.x 输入是1 2 3 4，更新4 为 9。
    受到影响的是3 1 0。对3的位置，是6 + 7的和，所以要判断7是否是偶数。
    */

    public void update(int i, int val) {
        i += nums.length;
        tree[i] = val;
        int left = 0, right = 0;
        while (i > 0) {
            if (i % 2 == 0) {
                left = i; right = i + 1;
            }
            else {
                left = i - 1; right = i;
            }
            tree[i / 2] = tree[left] + tree[right];
            i /= 2;
        }
    }

    /*
    保证 tree[i] = tree[2i] + tree[2i + 1]
    0   1 2 3 || 4 5 6 7

    13 10 3 7 || 1 2 3 4
    求 5 到 7 的和
    默认左是偶数，右是奇数。
    5 + 6 + 7 ->
    5 不是偶数，就直接加5
    左边右移

    7是
    */

    public int sumRange(int i, int j) {
        i += nums.length;
        j += nums.length;
        int sum = 0;
        // 这个写法类似binary search。搜到根结点位置，左 <= 右 所以是logn
        while (i <= j) {
            // 最后i 和 j 相遇，肯定会进入下面一个循环，

            // 左边是奇数，那么就向右移动一位
            if (i % 2 == 1) {
                sum += tree[i];
                i++;
            }
            // 右边是偶数，就向左移动一位
            if (j % 2 == 0) {
                sum += tree[j];
                j--;
            }
            i /= 2;
            j /= 2;
        }
        return sum;
    }
}



