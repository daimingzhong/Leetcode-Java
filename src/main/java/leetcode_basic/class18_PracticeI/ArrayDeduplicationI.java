package leetcode_basic.class18_PracticeI;

import java.util.Arrays;

/**
 * Created by Dai on 2016/11/13.
 * {1, 2, 2, 3, 3, 3} → {1, 2, 3}
 */
public class ArrayDeduplicationI {
    public int[] dedupI(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        if (array.length == 1) {
            return array;
        }
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[end]) {
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, end + 1);
    }

    public int[] dedup2(int[] array) {
        if (array.length == 1) {
            return array;
        }
        return null;
    }

    public  static void main (String[] args) {
        ArrayDeduplicationI array = new ArrayDeduplicationI();
        int[] a1 = {};
        System.out.println(Arrays.toString(array.dedupI(a1)));
    } 
}