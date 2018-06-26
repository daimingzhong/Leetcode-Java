package leetcode_basic.class98;

import java.util.*;

/**
 * Created by Dai on 2017/1/1.

 A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
 A = {}, B = {3, 1, 4}, return []

 如果ArrayList的存放对象实现了comparable接口，就可以用Collections.sort(Arraylist)方法，不然要手写comparator。
 String和Integer都实现了comparable接口。string默认的是字典排序，101 < 9

 */
public class CommonNumbersOfTwoArraysI {
    public List<Integer> common(List<Integer> a, List<Integer> b) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (Integer i : a) { // 不要忘了确定类型
            set.add(i);
        }
        for (Integer i : b) {
            if (set.contains(i)) {
               result.add(i);
            }
        }
        Collections.sort(result);
        return result;
    }
}