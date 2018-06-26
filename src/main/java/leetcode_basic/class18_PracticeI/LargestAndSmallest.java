package leetcode_basic.class18_PracticeI;

import java.util.Arrays;

/**
 * Created by Dai on 2016/12/28.
 * Use the least number of comparisons to get the largest and smallest number in the given integer array.
 * Return the largest number and the smallest number.
 * Assumptions
 * The given array is not null and has length of at least 1
 * {2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. return [5, 1].
 */
public class LargestAndSmallest {
    public int[] largestAndSmallest(int[] array) {
        if (array.length == 1) {
            return new int[]{array[0], array[0]};
        }
        for (int i = 0; i < array.length/2; i++) {
            if (array[i] < array[i + array.length/2]) {
                swap(array, i, i + array.length/2);
            }
        }
        int[] result = new int[]{array[0], array[array.length/2]};
        // System.out.println(Arrays.toString(new int[2])); // [0,0]
        for (int i = 0; i < array.length/2; i++) {
            if (array[i] > result[0]) {
                result[0] = array[i];
            }
        }
        for (int i = array.length/2; i<array.length; i++) {
            if (array[i] < result[1]) {
                result[1] = array[i];
            }
        }
        if (result[0] < array[array.length - 1]) {
            result[0] = array[array.length - 1];
        }
        if (result[1] > array[array.length - 1]) {
            result[1] = array[array.length - 1];
        }
        return result;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main (String[] args) {
        LargestAndSmallest ls = new LargestAndSmallest();
        int[] result = ls.largestAndSmallest(new int[]{1});
        System.out.print(Arrays.toString(result));
    }
}