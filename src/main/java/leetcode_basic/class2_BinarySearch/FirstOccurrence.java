package leetcode_basic.class2_BinarySearch;

/**
 * Created by Dai on 2016/11/23.
 * A = {1, 2, 3}, T = 2, return 1
 A = {1, 2, 3}, T = 4, return -1
 A = {1, 2, 2, 2, 3}, T = 2, return 1

 *    1  2 2 4  6  6 7       2
 *    1      4
 *    1  2
 *       2
 */
public class FirstOccurrence {
    public int firstOccur (int[] array, int target) {
        int left = 0;
        int right = array.length -1 ;
        while (left <= right) {
            int mid = left + (right - left)/2 ;
            if (array[mid] > target) {
                right = mid-1;
            }
            else if ( array[mid] < target) {
                left = mid+1;
            }
            if (array[mid] == target) {
                right = mid;
                if (array[left] == target) {
                    return left;
                }
                else {
                    left ++;
                }
            }
        }
        return -1;
    }

    public int firstOccur2 (int[] array, int target) {
        if (array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length -1 ;
        while (left < right - 1) { // 最后左右各一个数
            int mid = left + (right - left)/2 ; //不能写在上面，因为每次要重新计算mid
            if (array[mid] >= target) { // >=
                right = mid;            // =
            } else if (array[mid] < target) {
                left = mid;
            }
        }
         if (array[left] == target) {
             return left;
         }
         else if (array[right] == target) {
             return right;
         }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,1,2,2,3,4};
        int target = 2;
        FirstOccurrence fo = new FirstOccurrence();
        int k = fo.firstOccur2(array, target);
        System.out.print(k);
    }
}
