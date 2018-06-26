package leetcode_basic.class7_Hash;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dai on 2016/12/7.
 * input = "abcda", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
 */
public class RemoveCertainChars {
    public String remove(String input, String t) {
        StringBuilder result = new StringBuilder();
        char[] array = input.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        for (int i = 0; i < input.length(); i++) {
            if (!set.contains(input.charAt(i))){
                result.append(input.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main (String[] args) {
        RemoveCertainChars rm = new RemoveCertainChars();
        System.out.print(rm.remove(new String("abcba"), new String("ab")));
    }

}