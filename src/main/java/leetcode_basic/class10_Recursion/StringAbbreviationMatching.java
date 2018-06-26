package leetcode_basic.class10_Recursion;

/**
 * Created by Dai on 2016/12/10.
 * Assumption: The original string only contains alphabetic characters.
 * pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
 */
public class StringAbbreviationMatching {
    public boolean match(String input, String pattern) {
        int si = 0;
        int ti = 0;
        while (si < input.length() && ti < pattern.length()) {
            if (pattern.charAt(ti) < '0' || pattern.charAt(ti) > '9') {
                if (input.charAt(si) != pattern.charAt(ti)) {
                    return false;
                }
                si++;
                ti++;
            }
            else {
                int count = 0;
                while(ti < pattern.length() && pattern.charAt(ti) >= '0' && pattern.charAt(ti) <= '9') {
                    count = count * 10 + (pattern.charAt(ti) - '0');
                    ti++;
                }
                si = si + count;
            }
        }
        return si == input.length() && ti == pattern.length();
    }

    public static void main (String[] args) {
        StringAbbreviationMatching sa = new StringAbbreviationMatching();
        System.out.print(sa.match("leetcodecom", "l10"));
    }
}
