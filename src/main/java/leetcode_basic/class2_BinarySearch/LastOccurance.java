package leetcode_basic.class2_BinarySearch;

/**
 * Created by Dai on 2016/11/23.
 * A = {1, 2, 3}, T = 2, return 1
 A = {1, 2, 3}, T = 4, return -1
 A = {1, 2, 2, 2, 3}, T = 2, return 3
 */
public class LastOccurance {
    public int lastOccur (int[] array,int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length -1 ;
        int mid = 0;
        while (left < right - 1) {
            mid = left + (right - left)/2;
            if (array[mid] > target) {
                right = mid;
            }
            else if (array[mid] <= target) {
                left = mid;
            }
        }
        if (array[right] == target) { // first return right!!! left and right can be the same value.
            return right;
        }
        else if (array[left] == target) {
            return left;
        }
        else {
            return  -1;
        }
    }
    public static void main (String[] args) {
        LastOccurance lo = new LastOccurance();
        int[] a = {1, 2, 2, 2, 3};
        int target = 2;
        int result = lo.lastOccur(a, target);
        System.out.print(result);
    }
}
