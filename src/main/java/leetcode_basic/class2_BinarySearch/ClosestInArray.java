package leetcode_basic.class2_BinarySearch;

/**
 * Created by Dai on 2016/11/23.
 * A = {1, 2, 3}, T = 2, return 1
 A = {1, 4, 6}, T = 3, return 1
 A = {1, 4, 6}, T = 5, return 1 or 2。下标
 A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
 */

public class ClosestInArray {
    public int closest (int[] array, int target) {
        if (array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length -1 ;
        while (left < right -1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
            if (Math.abs(array[left]-target) <= Math.abs(array[right]-target)) {
                return left;
            }
            return right;
        }

    // 递归写法，醉了。
    public int closest2 (int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int index = closest(array, 0, array.length - 1, target);
        if (index == array.length - 1) {return index;}
        if (Math.abs(array[index] - target) < Math.abs(array[index + 1] - target)) {
            return index;
        }
        return index + 1;
    }


    private int closest(int[] array, int left, int right, int target) {
        if (left == right - 1) {
            return left;
        }
        int mid = (left + right) / 2;
        if (array[mid] <= target) {
            return closest(array, mid, right, target);
        } else {
            return closest(array, left, mid, target);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,3,3,4};
        int target = 2;
        ClosestInArray ca = new ClosestInArray();
        System.out.print(ca.closest(array,target));
    }
}

