package leetcode_basic.class7_Hash;

import java.util.*;

/**
 * Created by Dai on 2016/12/4.
 * Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"]
 * top 4 frequent words are [“b”, “c”, "a", "d"]
 */

public class TopKFrequentWords {
    public String[] topKFrequent(String[] combo, int k) {
        // use HashMap, key vaule pair -- string, times
        if(combo.length == 0) {
            return new String[0];
        }
        Map<String, Integer> map = new HashMap<>(); // 不能用int作为map类型
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
                // 返回值不是boolean，是int，所以用compareTo，不是equals.
                // 是不是实现maxHeap，直接用 - compareTo呢
            }
        });
        for (String s : combo) {
            if (!map.containsKey(s)) {
                map.put(s, 0);
            }
            map.put(s, map.get(s) + 1); // map.get(s) 返回一个reference，不能++操作
        }
        // 第二次遍历，要在map里，不能再string里，因为string并不知道频率
        for (Map.Entry<String, Integer> pair : map.entrySet()) { // Set<Map.Entry<K,V>>	entrySet()
            //Returns a Set view of the mappings contained in this map.
            if (minHeap.size() < k) { // 这里每次都要想好最后一次情况。 如果是 <= 就会变成 k + 1
                minHeap.offer(pair);
            }
            else {
                if (pair.getValue() > minHeap.peek().getValue()) { // 太容易错了，peek.getValue
                    minHeap.poll();
                    minHeap.offer(pair);
                }
            }
        }
//        StringBuilder string = new StringBuilder () ;
//        for (Map.Entry<String, Integer> pair : minHeap) {
//            string.append(pair.getValue());
//        }
//        return  string.t();
        String[] result = new String[minHeap.size()]; // heap是size不是length 而且 size 就是 size，虽然从0开始，但是size不变
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
    public static void main(String[] args) {
        TopKFrequentWords tp = new TopKFrequentWords();
        String[] a = {"a", "a", "b", "c"};
        String [] result = tp.topKFrequent(a ,2); //
        System.out.println(Arrays.toString(result)); //
    }
}
