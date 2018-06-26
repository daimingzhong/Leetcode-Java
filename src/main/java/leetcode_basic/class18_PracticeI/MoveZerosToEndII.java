package leetcode_basic.class18_PracticeI;

import java.util.Arrays;

/**
 * Created by Dai on 2016/12/29.
 * Given an array of integers, move all the 0s to the right end of the array.
 * The relative order of the elements in the original array need to be maintained.
 * Assumptions:
 * The given array is not null
 * Examples:
 * 1} --> {1}
 * {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
 */
public class MoveZerosToEndII {
    public int[] moveZero(int[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                swap(array, i,j);
                j++;
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        MoveZerosToEndII mz = new MoveZerosToEndII();
        int[] result = mz.moveZero(new int[]{});
        System.out.print(Arrays.toString(result));
    }
}
