package leetcode_basic.class18_PracticeI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dai on 2016/12/29.
 * A1 = {2, 1, 2, 5, 9, 1, 7, 3}, A2 = {2, 1, 3}
 * A1 is sorted to {2, 2, 1, 1, 3, 5, 7, 9}
 * 出现过的，按出现的拍，没出现的，升序排。
 * 排序一类的问题，可以通过写一个MyComparotor来用Arrays.sort来做。
 */
public class SortInSpecifiedOrder {
    public int[] sortSpecial(int[] A1, int[] A2) {
        Integer[] refArray = toIntegerArray(A1);
        Arrays.sort(refArray, new MyComparator(A2));//用A2里的数作为判断标准，所以最开始就要用A2
        int[] result = toIntArray(refArray);
        return result;
    }

    static class MyComparator implements Comparator<Integer> {
        Map<Integer, Integer> map;
        public MyComparator(int[] array) {
            map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                map.put(array[i], i);
            }
        }
        @Override
        public int compare(Integer i1, Integer i2) {
            Integer index1 = map.get(i1);
            Integer index2 = map.get(i2);
            if (index1 != null && index2 != null) {
                return index1.compareTo(index2);// 如果两个都存在，比较出现的先后顺序。
            }
            else if (index1 == null && index2 == null){
                return i1.compareTo(i2);// 两个都不存在，就比较大小。如果不想比较，就不写这个 else if就行了
            }
            return index1 != null ? -1 : 1;// 1存在，返回-1，表示第二个大（小的放前面）
        }
    }

    private int[] toIntArray(Integer[] array) {
        int[] result = new int[array.length];
        for(int i = 0; i < array.length; i++){
            result[i] = array[i];
        }
        return result;
    }
    private Integer[] toIntegerArray(int[] array) {
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SortInSpecifiedOrder si = new SortInSpecifiedOrder();
        int[] result = si.sortSpecial(new int[]{2, 1, 2, 5, 9, 1, 7, 3}, new int[]{2,1,3});
        System.out.println(Arrays.toString(result));
    }
}