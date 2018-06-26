package leetcode_algorithm.class7_Hash;

/*
solution:
https://discuss.leetcode.com/topic/68976/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem

438. Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and
p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

method 1:
two hashMap: O(nk)


method 2: O(n)
one hashMap:
sliding window，记录fast - slow 之间的信息。
用一个counter计数当前为3，如果counter数变成0了，就加到结果里。

         0      1     2       3
s:       a      b     a       b
p:       a      b

slow     0
fast            1

hashMap: <a, 1>   <b, 1>

count = 2

 */


import java.util.*;

public class FindAllAnagramsInAString_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> hashMap = new HashMap<>();
        if (s.length() < p.length()) {
            return result;
        }
        int slow = 0, fast = 0, count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (hashMap.containsKey(p.charAt(i))) {
                hashMap.put(p.charAt(i), hashMap.get(p.charAt(i)) + 1);
            } else {
                hashMap.put(p.charAt(i), 1);
            }
            count = hashMap.size();
        }
        while (fast < s.length()) {
            if (fast - slow < p.length()) {
                count = insertToHashMap(hashMap, s, fast, count);
                fast++;
                if (count == 0) {
                    result.add(slow);
                }
            } else {//if (fast - slow == p.length()) {
                count = insertToHashMap(hashMap, s, fast, count);
                count = deleteFromHashMap(hashMap, s, slow, count);
                fast++;
                slow++;
                if (count == 0) {
                    result.add(slow);
                }
            }
        }
        return result;
    }

    private int insertToHashMap(Map<Character, Integer> hashMap, String p, int i, int count) {
        if (hashMap.containsKey(p.charAt(i))) {
            if(hashMap.get(p.charAt(i)) == 1) {
                count--;
            }
            if(hashMap.get(p.charAt(i)) == 0) {
                count++ ;
            }
            hashMap.put(p.charAt(i), hashMap.get(p.charAt(i)) - 1); // be careful of the logic
        }
        return count;
    }

    private int deleteFromHashMap(Map<Character, Integer> hashMap, String p, int i, int count) {
        if (hashMap.containsKey(p.charAt(i))) {
            if (hashMap.get(p.charAt(i)) == 0) {
                count++;
            }
            if (hashMap.get(p.charAt(i)) == -1) {
                count--;
            }
            hashMap.put(p.charAt(i), hashMap.get(p.charAt(i)) + 1);

        }
        return count;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        String t = new String(p);
        List<Integer> result = new LinkedList<>();
        if (t.length() > s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int begin = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    counter--;
                }
            }
            end++;
            if (counter == 0) {
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if (end - begin == t.length()) {
                    result.add(begin);
                }
                begin++;
            }

        }
        return result;
    }




    List<Integer> findAnagrams3(String s, String l) {
        List<Integer> result = new ArrayList<>();
        if (l.length() == 0) {
            return result;
        }
        if (s.length() > l.length()) {
            return result;
        }
        Map<Character, Integer> map = creatMap(s);
        int match = 0; // 用match数量判断是否合法
        for (int i = 0; i < l.length(); i++) {
            char tmp = l.charAt(i);
            Integer count = map.get(tmp);
            // 最右边
            if (count != null) { // 当前的数在map里有
                count--;// 次数减1
                map.put(tmp, count);
                if (count == 0) {
                    match++;// 有一个数完全匹配上了
                }
            }

            // 最左边
            if (i >= s.length()) {
                tmp = l.charAt(i - s.length()); // 向前看s长度
                count = map.get(tmp);
                if (count != null) {
                    map.put(tmp, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                result.add(i - s.length() + 1);
            }
        }
        return result;
    }

    private Map<Character, Integer> creatMap(String input){
        // 函数比代码块有更好的重用性，比如这题把s 和 l 弄反了，写代码块就需要改很多地方。
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < input.length(); i++) {
            if (!map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i),1);
            }
            else {
                map.put(input.charAt(i), map.get(input.charAt(i))+1);
            }
        }
        return map;
    }


    public static void main(String[] args) {
        FindAllAnagramsInAString_438 fa = new FindAllAnagramsInAString_438();
        List<Integer> res = fa.findAnagrams("aaba", "aab");
        System.out.println(res);
    }
}