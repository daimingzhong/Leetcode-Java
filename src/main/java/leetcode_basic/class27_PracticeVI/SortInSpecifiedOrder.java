package leetcode_basic.class27_PracticeVI;

/*
A1 = {2, 1, 2, 5, 7, 1, 9, 3}
A2 = {2, 1, 3}

A1 is sorted to {2, 2, 1, 1, 3, 5, 7, 9}

 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortInSpecifiedOrder {

    static class MyComparator implements Comparator<Integer> {

        private Map<Integer, Integer> map;

        public MyComparator (int[] array) {
            map = new HashMap<>();
            for(int i = 0; i < array.length; i++) {
                map.put(array[i], i);
            }
        }

        @Override
        public int compare (Integer i1, Integer i2) {
            Integer index1 = map.get(i1);
            Integer index2 = map.get(i2);
            if (index1 != null && index2 != null) {
                return index1.compareTo(index2);
            }
            if (index1 == null && index2 == null) {
                return  i1.compareTo(i2);
            }
            return index1 != null ? -1 : 1;
        }
    }

    public int[] sortSpecial(int[] A1, int[] A2) { // 两个A1会报错，A1 already defined，所以在这里其实定义了两个变量
        Integer[] refArray = toIntegerArray(A1);
        Arrays.sort(refArray, new MyComparator(A2));
        toIntArray(refArray, A1);
        return A1;
    }

    private void toIntArray(Integer[] array, int[] result) {
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
    }

    private Integer[] toIntegerArray(int[] array) {
        Integer[] result = new Integer[array.length];
        for(int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SortInSpecifiedOrder sortInSpecifiedOrder = new SortInSpecifiedOrder();
        int[] A1 = {2, 1, 2, 5, 7, 1, 9, 3};
        int[] A2 = {2, 1, 3};
        int[] res = sortInSpecifiedOrder.sortSpecial(A1, A2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
