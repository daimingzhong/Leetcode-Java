package leetcode_algorithm.class7_Hash;

import java.util.HashMap;
import java.util.Map;

/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

 */
public class Word_Pattern_290 {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.length() == 0 && str.length() == 0) {
            return true;
        }
        Map<String, Character> hashMap = new HashMap<>();
        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length) {
            return false;
        }
        for(int i = 0; i < strArray.length; i++) {
            if(!hashMap.containsKey(strArray[i])) {
                if(hashMap.containsValue(pattern.charAt(i))) {
                    return false;
                }
                hashMap.put(strArray[i], pattern.charAt(i));
            } else {
                if(hashMap.get(strArray[i]) != pattern.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}