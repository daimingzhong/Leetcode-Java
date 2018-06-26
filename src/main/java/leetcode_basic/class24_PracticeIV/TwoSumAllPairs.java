package leetcode_basic.class24_PracticeIV;

import java.util.*;

/**
 * Created by Dai on 2016/12/2.
 * HashSet 本身就采用 HashMap 来实现的。
 * get 由key得到value
 * put 存一个数，尽量少的哈希冲突。key需要唯一，不唯一，会替代原来的值
 */
public class TwoSumAllPairs {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < array.length; i++) {
            // V	get(Object key) Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
            List<Integer> indices = map.get(target - array[i]); // 因为返回值是V，所以要用List
            // 先判断，再加值，出现过的值加了进去
            if (indices != null) {
                for (int j : indices) { // 先加j
                    result.add(Arrays.asList(j,i));
                    // ArrayList array as List. （“ab”,“cd”）把一个字符串变成了一个ArrayList
                    // 把array变成list。array好理解，list到底是个啥，list是可以根据位置找值的表（一个会计表）
                }
            }
            if (!map.containsKey(array[i])) { //链表的结构。如果还没有加过key（值）的话，加进去，并且新建一个ArrayList
                map.put(array[i], new ArrayList<Integer>());
            }
            map.get(array[i]).add(i); //V, get(Object key) Returns the value to which the specified key is mapped,
            // or null if this map contains no mapping for the key.
            // 在key array[i]的位置处，链表增添一个数。（如果之前没有这个链表，上一步创建了）
        }
        return result;
    }

    // 以值为key，以位置为value，创建值可重复的hashMap。
    public Map<Integer, List<Integer>> creatHashMap (int[] array) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) { // 先写没有contain的情况，因为有没有contain都得add
                map.put(array[i],new ArrayList<>());
            }
            map.get(array[i]).add(i); // 最后再加入该数。为了实现在一个链表中添加，先获得链表，用get，返回的就是链表
        }
        return map;
    }

        public List<List<Integer>> allPairs2 (int[] array, int target) {
            // 先加在判断不好。因为这样要判断是否是刚加的数。能做，但是ugly
            Map<Integer, List<Integer>> map = new HashMap<>();
            List<List<Integer>> result = new ArrayList<List<Integer>>(); // 第二个里面的Integer不能省 ？？？？？
            for (int i = 0; i <= array.length; i++) {
                if (!map.containsKey(i)) { //boolean	containsKey(Object key Returns true if this map contains a mapping for the specified key.
                    map.put(array[i], new ArrayList<>()); // 这里不能用List了，因为List只是个interface，这里要实实在在插入数了
                }
                map.get(array[i]).add(i);
            }
            return  result;
        }

    public static void main (String[] args) {
        TwoSumAllPairs ts = new TwoSumAllPairs();
        int[] array = {1,2,3,4,5,5};
        System.out.println(ts.allPairs(array,6));
    }
}
