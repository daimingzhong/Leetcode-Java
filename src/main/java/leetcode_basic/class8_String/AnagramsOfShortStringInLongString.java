package leetcode_basic.class8_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by Dai on 2016/12/8.
 * l = "abcbac", s = "ab", return [0, 3]
 * since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
 * 这是道固定窗口的题。需要维护窗口内数值的进出，对hashMap采取操作，对应的match更改。
 */
public class AnagramsOfShortStringInLongString {
    public List<Integer> allAnagrams(String s, String l) {
        List<Integer> result = new ArrayList<>();
        if (l.length() == 0) {
            return result;
        }
        if (s.length() > l.length()) {
            return result;
        }
        Map<Character, Integer> map = creatMap(s);
        int match = 0;
        for (int i = 0; i < l.length(); i++) {
            char tmp = l.charAt(i);
            Integer count = map.get(tmp);

            if (count != null) {
                map.put(tmp, count - 1);
                if (count == 1) {
                    match++;
                }
            }

            if (i >= s.length()) {
                tmp = l.charAt(i - s.length());
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

    public static  void main(String[] args) {
        AnagramsOfShortStringInLongString aa = new AnagramsOfShortStringInLongString();
        System.out.print(aa.allAnagrams("abbc", "aaaaabbc"));
    }
}
