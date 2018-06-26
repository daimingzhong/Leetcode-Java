package leetcode_basic.class98;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dai on 2017/1/1.
  同构字符串，A中的一个字符可以被B中的替换
  "abca" and "xyzx" are isomorphic since the mapping is 'a' <-> 'x', 'b' <-> 'y', 'c' <-> 'z'.
 "abba" and "cccc" are not isomorphic.


 */
public class IsomorphicStringI {
    public boolean isomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
            else if (t.charAt(i) != map.get(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static void main (String[] args) {
        IsomorphicStringI is = new IsomorphicStringI();
        boolean result = is.isomorphic("aba","afa");
        System.out.print(result);
    }
}