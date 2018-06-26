package leetcode_basic.class8_String;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dai on 2016/12/8.
 * the longest substring without repeating letters
 * for example" "bcdfbd" is "bcdf",
 * return 4 in this case.
 */


// topic: sliding window.
public class LongestSubstring {
    public int longest(String input) {
        if (input.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = 0;
        int fast = 0;
        int slow = 0;
        while (fast < input.length()) {
            if (set.contains(input.charAt(fast))){
                set.remove(input.charAt(slow));
                slow++;
            }
            else {
                set.add(input.charAt(fast));
                fast++;
                max = Math.max(max, fast - slow);
            }
        }
        return max;
    }
    public static void main (String[] args) {
        LongestSubstring ls = new LongestSubstring();
        System.out.print(ls.longest("abb"));
    }
}
