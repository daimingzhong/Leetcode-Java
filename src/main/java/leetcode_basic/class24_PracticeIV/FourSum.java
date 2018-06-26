package leetcode_basic.class24_PracticeIV;

import java.util.Arrays;

/**
 * Created by Dai on 2016/12/3.
 * A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 8)
 */
public class FourSum {
    public boolean exist(int[] array, int target) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i++) {
            for (int j = i + 1; j < array.length - 2; j++) {
                int left = j + 1;
                int right = array.length - 1;
                while (left < right) {
                    int tmp = array[i] + array[j] + array[left] + array[right];
                    if (tmp == target) {
                        return true;
                    } else if (tmp < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return false;
    }

    public static void main (String[] args) {
        FourSum fs = new FourSum();
        int[] array = {3,1,6,3,16,40};
        System.out.println(fs.exist(array,13));
    }
}
