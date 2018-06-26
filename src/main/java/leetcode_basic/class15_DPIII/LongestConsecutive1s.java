package leetcode_basic.class15_DPIII;

/**
 * Created by Dai on 2017/1/3.
 * {0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.
 */
public class LongestConsecutive1s {
    public int longest(int[] array) {
        int[] result = new int[array.length + 1];
        result[0] = 0;
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                result[i + 1] = result[i] + 1; // record the longest length right now
                if (result[i + 1] > res) {
                    res = result[i + 1];
                }
            }
            else {
                result[i + 1] = 0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        LongestConsecutive1s lc = new LongestConsecutive1s();
        int result = lc.longest(new int[]{0, 1, 0, 1, 1, 1, 0});
        System.out.print(result);
    }
}
