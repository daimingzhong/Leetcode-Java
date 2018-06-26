package leetcode_basic.class12_DP;

/**
 * Created by Dai on 2016/12/10.
 * {7, 2, 3, 1, 5, 8, 9, 6}
 *  longest ascending subarray is {1, 5, 8, 9}, length is 4.
 */
public class LongestAscendingSubArray {
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] m = new int[array.length];
        m[0] = 1;
        int max = 1;
        for (int i = 1; i <= array.length - 1; i++) {
            if (array[i] > array[i - 1]) {
                m[i] = m[i - 1] + 1;
            } else {
                m[i] = 1;
            }
            if (m[i] > max) {
                max = m[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestAscendingSubArray solution = new LongestAscendingSubArray();
        int[] array = {7, 2, 3, 1, 5, 8, 9, 6};
        // 1 2 1 2 1 2 3 4 5 1
        // base case: m[0] = 1
        // induction rule : m[k] = m[k-1] + 1,
        // if array[k] > array[k-1], else m[k] = 1;
        int k = solution.longest(array);
        System.out.println(k);
    }
}