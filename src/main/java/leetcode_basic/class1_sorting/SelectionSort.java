package leetcode_basic.class1_sorting;
/**
 * Created by Dai on 2016/12/23.
 * {3,1,2,6} 排序过程
 * {1,3,2,6}
 * {1,2,3,6}
 * for everytime select a smallest one. exchange it with the current point.
 */



public class SelectionSort {
    public int[] solve(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i <= array.length - 1; i++) {
            int key = i;
            for (int j = i; j <= array.length - 1; j++) {
                if (array[j] < array[key])
                    key = j;
            }
            int tmp = array[i];
            array[i] = array[key];
            array[key] = tmp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = {4, 6, 1, 5, 2, 7, 3};
        SelectionSort b = new SelectionSort();
        b.solve(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
