package leetcode_basic.class98;

/**
 * Created by Dai on 2017/1/1.
 */
public class MissingNumberII {
    public int missing(int[] array) {
        if (array.length == 0) {
            return 1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1) {
                return i + 1;
            }
        }
        return array[array.length - 1] + 1;
    }
}
