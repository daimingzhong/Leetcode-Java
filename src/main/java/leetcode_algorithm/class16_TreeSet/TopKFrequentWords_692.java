package leetcode_algorithm.class16_TreeSet;

import java.util.*;

/*
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

注意：
String 字典序比较大小  s1.compareTo(s2)
String 是否相等 s1.equals(s2)

Integer
!= 是可以的
== 不行。 因为-127-128之外的，是比较内存地址。
一般用 a1.equals(a2)

写法：
1. 比较Integer是否相等  .equals
2. 比较String .compareTo()

 */


public class TopKFrequentWords_692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
            // count.get(word)  + 1  getOrDefault(word, 0) + 1
        }
        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> !count.get(w1).equals(count.get(w2)) ? count.get(w1) - count.get(w2) : w2.compareTo(w1));

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) {
            ans.add(heap.poll());

        }
        Collections.reverse(ans);
        return ans;
    }


    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList<>(count.keySet());
        Collections.sort(candidates, (w1, w2) -> !count.get(w1).equals(count.get(w2)) ? count.get(w2) - count.get(w1) : w1.compareTo(w2));

        return candidates.subList(0, k);
    }


    // treemap 是 key 排序，value不排序。所以对这题是行不通的。
    public List<String> topKFrequent3(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new TreeMap<>(); // key 要实现 compareTo方法
        for(String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        return res;
    }

    // treeset 要对key都排序。所以要建立一个class。但是key又是不允许改变的。这就很蛋疼。可以每次删掉一个记录，再更新一个记录。
    // 这个方法没有写比较器。不能用
    public List<String> topKFrequent4(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        TreeSet<Map.Entry<String, Integer>> set =  new TreeSet<>();
        for(String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(Map.Entry<String, Integer> pair : map.entrySet()) {
            set.add(pair);
            if (set.size() > k) {
                set.pollFirst();
            }
        }
        return res;
    }

    //用treeset。里面的范性要实现compararable<T>.
    public List<String> topKFrequent5(String[] words, int k) {
        class MyPair implements Comparable<MyPair>{
            private String name;
            private int count;

            public MyPair(String name, int count) {
                this.name = name;
                this.count = count;
            }

            @Override
            public int compareTo(MyPair myPair) {
                // 当前的其实是this。如果要把次数少的放在上面，那么应该用当前 - 传进来的
                if (myPair.count != this.count) {
                    return this.count - myPair.count;
                }
                else{
                    return this.name.compareTo(myPair.name);
                }
            }
        }

        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        TreeSet<MyPair> treeSet =  new TreeSet<>();
        for(String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(String string : map.keySet()) {
            treeSet.add(new MyPair(string, map.get(string)));
            if (treeSet.size() > k) {
                treeSet.pollFirst();
            }
        }
        Iterator<MyPair> myPairs = treeSet.iterator();
        while(myPairs.hasNext()) {
            res.add(myPairs.next().name);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentWords_692 topKFrequentWords_692 = new TopKFrequentWords_692();
        String[] input = {"the", "the", "the", "the", "is", "is", "is", "sunny", "sunny", "day"};
        List<String> res = topKFrequentWords_692.topKFrequent5(input, 4);
        System.out.println(res);
    }
}
