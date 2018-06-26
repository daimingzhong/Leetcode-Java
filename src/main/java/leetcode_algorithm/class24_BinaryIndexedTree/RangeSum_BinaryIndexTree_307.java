package leetcode_algorithm.class24_BinaryIndexedTree;

/*
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
 */

public class RangeSum_BinaryIndexTree_307 {
    private int[] nums;
    private int[] tree;

    public RangeSum_BinaryIndexTree_307(int[] nums) { // time : O(n * logn)
        this.nums = new int[nums.length];
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        if (nums.length == 0) {
            return;
        }
        int diff = val - nums[i];
        nums[i] = val;
        for (int j = i + 1; j <= nums.length; j += lowbit(j)) {
            tree[j] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return getPrefixSum(j + 1) - getPrefixSum(i);
    }

    private int getPrefixSum(int k) {
        int sum = 0;
        for (int i = k; i > 0; i -= lowbit(i)) {
            sum += tree[i];
        }
        return sum;
    }

    private int lowbit(int x) {
        return x & (-x);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        RangeSum_BinaryIndexTree_307 rangeSumQueryMutable_307 = new RangeSum_BinaryIndexTree_307(nums);
        System.out.println(rangeSumQueryMutable_307.sumRange(0, 2));
        rangeSumQueryMutable_307.update(1, 2);
        System.out.println(rangeSumQueryMutable_307.sumRange(0, 2));
    }
}

//
//    /**
//     * Method 2
//     */
//    //private int[] tree;
//    //private int[] nums;
//
//    public void NumArray(int[] nums) {
//        this.nums = nums;
//        int sum;
//        int lowbit;
//        tree = new int[nums.length + 1];
//        for (int i = 1; i < tree.length; i++) {
//            sum = 0;
//            lowbit = i & (-i);
//            for (int j = i; j > i - lowbit; j--) {
//                sum = sum + nums[j - 1];
//            }
//            tree[i] = sum;
//        }
//    }
//
//    public void update2(int i, int val) {
//        int diff = val - nums[i];
//        nums[i] = val;
//        i++;
//        for (; i < tree.length; i += (i & (-i))) {
//            tree[i] += diff;
//        }
//    }
//
//    public int sumRange2(int i, int j) {
//        return sum2(j + 1) - sum2(i);
//    }
//
//    private int sum2(int k) {
//        int sum = 0;
//        for (int i = k; i > 0; i -= i & (-i)) {
//            sum += tree[i];
//        }
//        return sum;
//    }