package leetcode_basic.class18_PracticeI;

import java.util.Arrays;

/**
 * Created by Dai on 2016/12/26.
 * 重复的全都得删掉
 * {1, 2, 2, 3, 3, 3} → {1}
 */
public class ArrayDeduplicationIII {
        public int[] dedup(int[] array) {
            if (array.length <= 1) {
                return array;
            }
            int j = 0;
            boolean flag = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] == array[j]) {
                    flag = true;
                }
                else if (flag) { // 用上一个控制下一个
                    array[j] = array[i];
                    flag = false;
                }
                else {
                    array[++j] = array[i];
                }
            }
            if (flag) {
                return Arrays.copyOf(array,j);
            }
            else {
                return Arrays.copyOf(array, j+1);
            }
        }

        public int[] dedup2(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int j = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] != array[i - 1] && array[i + 1] != array[i]) {
                array[++j] = array[i];
            }
        }
        if (array[array.length - 1] != array[array.length- 2]) {
            array[++j] = array[array.length - 1];
        }
        return Arrays.copyOf(array,j+1); // 没有考虑第一个数，再写个函数整个迁移
    }

    public static void main(String[] args) {
        ArrayDeduplicationIII array = new ArrayDeduplicationIII();
        int[] a1 = {1,1,2,2,3};
        System.out.println(Arrays.toString(array.dedup(a1)));
    }
}