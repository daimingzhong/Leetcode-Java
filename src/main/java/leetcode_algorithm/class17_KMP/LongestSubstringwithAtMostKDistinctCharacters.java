package leetcode_algorithm.class17_KMP;

import java.util.*;

/**
 * Project Name : Leetcode
 * Package Name : leetcode_solution
 * File Name : LongestSubstringwithAtMostKDistinctCharacters
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 340. Longest Substring with At Most K Distinct Characters
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
    /**
     * Given a string, find the length of the longest substring T that contains
     * at most k distinct characters.

     For example, Given s = “eceba” and k = 2,

     T is "ece" which its length is 3.

     sliding window

     time : O(n)
     space : O(1)

     */

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int res = 0, num = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(j++)] > 0);
                num--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstringKDistinct2(String str, int k) {
        if (str == null || str.isEmpty() || k == 0) {
            return 0;
        }
        TreeMap<Integer, Character> lastOccurrence = new TreeMap<>();
        Map<Character, Integer> inWindow = new HashMap<>();
        int j = 0;
        int max = 1;
        for (int i = 0; i < str.length(); i++) {
            char in = str.charAt(i);
            while (inWindow.size() == k && !inWindow.containsKey(in)) {
                int first = lastOccurrence.firstKey();
                char out = lastOccurrence.get(first);
                inWindow.remove(out);
                lastOccurrence.remove(first);
                j = first + 1;
            }
            //update or add in's position in both maps
            if (inWindow.containsKey(in)) {
                lastOccurrence.remove(inWindow.get(in));
            }
            inWindow.put(in, i);
            lastOccurrence.put(i, in);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
