package leetcode_basic.class7_Hash;

import java.util.*;

/**
 * Created by Dai on 2016/12/4.
 * A = {1, 1, 2, 2, 3}
 * B = {1, 1, 2, 5, 6}
 * common numbers are [1, 1, 2]
 */
public class CommonNumbers {
    public List<Integer> common(List<Integer> A, List<Integer> B) { //形参可以用List，因为主函数用的是ArrayList
        // 原题是int[] a。 用双指针也可以，先a.size(), 再a.get()
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        for (Integer i : A) {
            if (mapA.containsKey(i)) {
                mapA.put(i, mapA.get(i) + 1);
            }
            else {
                mapA.put(i, 1);
            }
        }
        for (Integer i : B) {
            if (mapB.containsKey(i)) {
                mapB.put(i, mapB.get(i) + 1);
            } else {
                mapB.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : mapA.entrySet()) {
            Integer num = mapB.get(entry.getKey());
            if (num != null) {
                int count = Math.min(entry.getValue(), num);
                for (int i = 0; i < count; i++) {
                    result.add(entry.getKey());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CommonNumbers cn = new CommonNumbers();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);
        b.add(1);
        b.add(1);
        b.add(2);
        b.add(5);
        b.add(6);
        List<Integer> c = Arrays.asList(new Integer[] {1,2,3,4,5});
        for (Integer i : cn.common(a,c)) {
            System.out.println(i);
        }
    }
}
