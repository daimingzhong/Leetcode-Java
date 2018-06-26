package leetcode_algorithm.class8_String;

/*

https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

You are given a string, s, and a list of words, words, that are all of the same length.
Find all starting indices of substring(s) in s that is a concatenation of each word
in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).

注意，每个单词是一样长度的。
这是一个滑动窗口的问题，用定长的窗口。

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenation_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || words == null || words.length == 0) return res;
        int len = words[0].length(); // length of each word

        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
        for (String w : words) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < words.length; j++) { // check if match
                String str = s.substring(i + j*len, i + j*len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str); //remove method
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else break; // not in L
            }
        }
        return res;
    }
}
