package leetcode_basic.class8_String;

/**
 * Created by Dai on 2016/12/7.
 * input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
 */
public class StringReplace {
    public String replace(String input, String s, String t) {
        StringBuilder sb = new StringBuilder();
        int fromIndex = 0;
        int matchIndex = input.indexOf(s, fromIndex);
        // Returns the index within this string of the first occurrence  from the specified index.
        while (matchIndex !=  -1) {
            sb.append(input, fromIndex, matchIndex).append(t);
            fromIndex = matchIndex + s.length();
            matchIndex = input.indexOf(s, fromIndex);
        }
        sb.append(input, fromIndex, input.length());
        return sb.toString();
    }
    public static void main (String[] args) {
        StringReplace sp = new StringReplace();
        System.out.print(sp.replace("cat cat like apple","cat","dog"));

    }
}
