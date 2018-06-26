package leetcode_algorithm.class8_String;

/*

3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

                            0   1   2   3   4
                            a   b   c   a   b   c   b   b

slow:                       0
fast:                       0           3
count                       +1
(fast is i ???)

move fast when:
move slow when: there appears a dupilcate value, slow++

hashSet save the value between [slow, fast] (window)
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    // for most 1 time, then hashset is enough
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hashSet = new HashSet<>();
        int slow = 0, fast = 0, result = 0;
//        for(int i = 0; i<s.length(); i++) {  // for不好使，是因为这里的 i 就是 fast， 但是fast并不是每次都会变。
//            if(!hashSet.contains(s.charAt(i))) {
//                hashSet.add(s.charAt(i));
//                result = Math.max(result, i - slow + 1);
//            } else{
//                while(hashSet.contains(s.charAt(slow))) {
//                    hashSet.remove(s.charAt(slow));
//                    slow++;
//                    hashSet.add(s.charAt(i));
//                }
//            }
//        }

        while(fast < s.length()) {
            if(!hashSet.contains(s.charAt(fast))) {
                result = Math.max(result, fast - slow + 1);
                hashSet.add(s.charAt(fast));
                fast++;
            } else{
                hashSet.remove(s.charAt(slow));
                slow++;
            }
        }
        return result;
    }

    public int lengthOfLongestSubstring(String s, int k) { // int k means at most k times.
        Map<Character, Integer> hashMap = new HashMap<>();
        return 0;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }
        int result = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    cur++;
                } else {
                    if (cur > result) {
                        result = cur;
                    }
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_3 ls = new LongestSubstringWithoutRepeatingCharacters_3();
        System.out.println(ls.lengthOfLongestSubstring("pwwkew"));
    }
}
