package leetcode_algorithm.class7_Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dai on 8/6/17.
 242. Valid Anagram

 Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?


 */

public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(int i = 0; i<s.length(); i++) {
            if(!sMap.containsKey(s.charAt(i))) {
                sMap.put((Character) s.charAt(i), 1);
            } else {
                sMap.put((Character) s.charAt(i), sMap.get(s.charAt(i)) + 1);
            }
        }
        for(int i = 0; i < t.length(); i++) {
            if(!sMap.containsKey(t.charAt(i))) {
                return false;
            }
            sMap.put((Character) t.charAt(i), sMap.get(t.charAt(i)) - 1);
        }
        for (Map.Entry<Character, Integer> entry: sMap.entrySet()) {
            if (entry.getValue()!= 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) { //
        int[] nums = new int[26];
        for(int i = 0; i<s.length(); i++) {
            nums[s.charAt(i) - 'a'] += 1;
        }
        for(int j = 0; j<t.length(); j++) {
            nums[t.charAt(j) - 'a'] -= 1;
        }
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("a","a"));
    }
}