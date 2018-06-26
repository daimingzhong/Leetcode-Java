package leetcode_basic.class24_PracticeIV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dai on 2016/12/3.
 * A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
 */
public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); // 为什么第二个Integer不能省
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i-1]) {
                continue;// 从后往前写程序不要忘了这一步
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int tmp = array[left] + array[right] + array[i];
                if (tmp == target) {
                    result.add(Arrays.asList(array[i], array[left], array[right])); // 在这里左右就不动了
                    left ++;
                    while (left < right && array[left] == array[left - 1]) {
                        left ++ ;
                    }
                }
                else if (tmp < target){
                    left ++;
                }
                else if (tmp > target) {
                    right --;
                }
            }
        }
        return result;
    }

    public static void main (String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] array = {1, 2, 2, 2, 2, 3, 4};
        System.out.println(ts.allTriples(array,8));
    }
}
