package leetcode_basic.class1_sorting;

import java.util.Arrays;

/**
 * Created by Dai on 2016/12/23.
 * {3,2,4,6,7,1}
 *
 *  3 1 4  | 6 7 1
 *  3 | 1 4
 *  3 | 1 | 4

 *  1  3 | 4
 *  1  3  4


 */

public class MergeSort {

    // 空间复杂度O(n) 因为传参很麻烦，所以用全局变量helper
    private int[] helper;

    public int[] mergeSort(int[] array) {
        helper = new int[array.length];
        if(array == null) {
            return null;
        }
        mergeSort(array, 0, array.length-1);
        return array;
    }

    // base case: only 1 element left.  => left > right
    // recursive rule: sort left and right half part separately.
    private void mergeSort(int[] array, int left, int right){
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;

        // 虚线以上
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        // 虚线以下
        merge(array, left, mid, right);
    }

    // Merge two sorted list. input is an array.
    // first array: left, mid. second array: mid + 1, right.
    // the value will be stored in helper[] temporarily.
    private void merge(int[] array, int left, int mid, int right ){
        for (int i = left; i <= right; i++){
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid+1;
        while (leftIndex <= mid && rightIndex <= right){
            // helper 1 3  | 2  4
            if (helper[leftIndex] <= helper[rightIndex]){
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
        }
        while(leftIndex<= mid) {
            array[left++] = helper[leftIndex++];
        }
    }

    public static void main(String[] args) {
        MergeSort solution = new MergeSort();
        int[] array;
        array = new int[] {4,2,1,6,3,5};
        System.out.println(Arrays.toString(solution.mergeSort(array)));
        array = new int[0];
        System.out.println(Arrays.toString(solution.mergeSort(array)));
    }
}

