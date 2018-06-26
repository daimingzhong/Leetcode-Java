package leetcode_basic.class2_BinarySearch;

/**
 * Created by Dai on 2016/11/23.
 A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
 A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 */

public class KClosest {
    public int[] kClosest(int[] array, int target, int k) {
        if (array == null || array.length == 0){
            return array;
        }
        if (k == 0) {
            return new int[0];
        }
        int left = helper(array, target);
        int right = left + 1 ;
        int[] result = new int[k];
        for (int i = 0; i < k ; i++ ) {
            if (right >= array.length || left >=0 && target - array[left] <= array[right] - target) {
                result[i] = array [left--] ;
            }
            else {
                result[i] = array [right++] ;
            }
        }
        return result;
    }

    private int helper (int[] array, int target) {
        int left = 0;
        int right = array.length -1 ;
        while (left < right -1) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[right] <= target) {
            return right;
        }
        if (array[left] <= target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,3,3,4};
        int target = 2;
        int k = 2;
        KClosest kl = new KClosest();
        for (int i = 0; i < k; i++) {
            System.out.println(kl.kClosest(array, target, k)[i]);
        }
    }
}
