package leetcode_algorithm.class2_BinarySearch;

/**
 * 33. Search in Rotated Sorted Array
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 */

public class SearchShiftedArray_33 {
    public int search(int[] array, int target) {
        if (array == null || array.length == 0) {
            // when the array is referencing null，
            // e.x. int[] a = null; simply means a is referencing to a null. a don't know which one to reference
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) { // left will be the largest, while right will be the smallest
            int middle = left + (right - left) / 2;
            if (array[middle] > array[left]) {
                left = middle;
            } else {
                right = middle;
            }
        }
        int leftPart = binarySearch(array, 0, left, target);
        int rightPart = binarySearch(array, right, array.length - 1, target);
        return Math.max(leftPart, rightPart);
    }

    private int binarySearch(int[] array, int left, int right, int target) {
        while (left < right - 1) {
            int middle = left + (right - left) / 2;
            if (array[middle] <= target) {
                left = middle;
            } else {
                right = middle;
            }
        }
        if (array[left] == target) {
            return left;
        }
        if (array[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchShiftedArray_33 searchShiftedArray = new SearchShiftedArray_33();
        int result = searchShiftedArray.search(null, 1);
        System.out.println(result);
    }
}