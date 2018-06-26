package leetcode_algorithm.class25_UnionFind;

/*
similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar,

相似性是有传染的，例如a b，b c，那么a c也相似。
 */

import leetcode_algorithm.class0.UnionFindSet;

import java.util.*;

public class SequenceSimilarityII_737 {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        UnionFindSet unionFindSet = new UnionFindSet(pairs.length * 2);
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String[] cur : pairs) {
            if (!map.containsKey(cur[0])) {
                map.put(cur[0], count++);
            }
            if (!map.containsKey(cur[1])) {
                map.put(cur[1], count++);
            }
            unionFindSet.union(map.get(cur[0]), map.get(cur[1]));
        }
        // union 从 0 开始， find 也要从 0 开始。
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            }
            if (!map.containsKey(words1[i]) || !map.containsKey(words2[i])) {
                return false;
            }
            if (unionFindSet.find(map.get(words1[i])) != unionFindSet.find(map.get(words2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Queue<Integer> queue  = new LinkedList<>();
//        queue.size()
//        Queue<Integer> temp = queue;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //map.floorKey()
        TreeSet<Integer> set = new TreeSet<>();
//        set.floor() set.ceiling()
    }
}