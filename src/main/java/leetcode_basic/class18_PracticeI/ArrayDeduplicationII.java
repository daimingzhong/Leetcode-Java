package leetcode_basic.class18_PracticeI;

import java.util.Arrays;

/**
 * Created by Dai on 2016/12/17.
 * Given a sorted integer array, remove duplicate elements.
 * For each group of elements with the same value keep at most two of them.
 * Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.
 * Assumptions The given array is not null
 * Examples {1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}
 */
public class ArrayDeduplicationII {
    public int[] dedup(int[] array) {
        if (array.length <= 2) {
            return array;
        }
        int j = 1;
        for (int i = 2; i < array.length; i++) {
            if (array[i] != array[j - 1]) {
                array[++j] = array[i];
            }
        }
        return Arrays.copyOf(array,j + 1);
    }

    public  static void main (String[] args) {
        ArrayDeduplicationII array = new ArrayDeduplicationII();
        int[] a1 = {3,3,3,4,4,5,5};
        System.out.println(Arrays.toString(array.dedup(a1)));
    }
}
