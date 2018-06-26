package leetcode_basic.class2_BinarySearch;

//输入是排序过的array，输入是数字的位置。
// Given a target integer T and an integer array A sorted in ascending order,
// find the index i such that A[i] == T or return -1 if there is no such index.
// A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3
public class BinarySearch {

    public int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (array[mid] > target) {
                end = mid;
            }
            if (array[mid] < target) {
                start = mid;
                //start = mid 会死循环 如{1，2,3} 找3，start，mid一直是2
            }
            else {
                return mid;
            }
        }
        if (array[start] == target) {
            return start;
        } else if (array[end] == target) {
            return end;
        }
        return -1;
    }

    public int binarySearch2(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid] == target)
                return mid;
            if (array[mid] > target) {
                end = mid-1;
            }
            if (array[mid] < target) {
                start = mid + 1;
                //start = mid 会死循环 如{1，2,3} 找3，start，mid一直是2
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 7, 9, 11};
        BinarySearch b = new BinarySearch();
        System.out.println(b.binarySearch2(a,3));
    }
}
