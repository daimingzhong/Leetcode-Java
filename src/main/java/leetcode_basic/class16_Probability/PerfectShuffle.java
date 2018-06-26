package leetcode_basic.class16_Probability;

import java.util.Arrays;

/**
 * Created by Dai on 2016/12/12.
 * Given an array of integers (without any duplicates), shuffle the array
 * such that all permutations are equally likely to be generated.
 * Assumptions The given array is not null
 */
public class PerfectShuffle {
    public void shuffle(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int i = array.length; i >= 1; i--) {
            int idx = (int) (Math.random() * i);
            swap(array, i - 1, idx);
        }
    }

    public void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main (String[] args) {
        PerfectShuffle ps = new PerfectShuffle();
        int[] result = new int[]{2,1,3};
        ps.shuffle(result);
        System.out.print(Arrays.toString(result));
    }
}
