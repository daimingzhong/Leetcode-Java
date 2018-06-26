package leetcode_basic.class90;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dai on 2017/1/4.
 *
 Given a string, we can insert at most one empty space between each pair of adjacent letters.  Print all permutations of strings after insertions of empty spaces.
 Input:  str[] = "ABC"
 Output:
 ABC
 AB C
 A BC
 A B C
 // dfs. select char or blank every time.
 // time complexity: O(n)
 // space complexity: O(n) -- n is the length
 */
public class SpacePermutation {
    public List<String> permutation(char[] string) {
        List<String> result = new ArrayList<>();
        if (string == null || string.length == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(result, sb, string, 0);
        return result;
    }

    private void helper(List<String> result, StringBuilder sb, char[] string, int level) {
        if (level == string.length - 1) {
            sb.append(string[level]);
            result.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        // case 1: add blank
        sb.append(string[level]);
        sb.append(' ');
        helper(result, sb, string, level + 1);
        sb.deleteCharAt(sb.length() - 1);

        // case 2: no blank added
        helper(result, sb, string, level + 1);
        sb.deleteCharAt(sb.length() - 1);
    }

    public List<String> permu(String input) {
            List<String> result = new ArrayList<>();
            StringBuilder tmp = new StringBuilder();
            if (input == null ) {
                return null;
            }
            int length = input.length();
            helper(result, tmp, input);
            return result;

        }

    private void helper(List<String> result, StringBuilder tmp, String input) {
        for (int i = 0; i < input.length(); i++) {
            tmp.append(input.charAt(i));
            tmp.append(' ');
            //tmp.delete(tmp.length());
            //tmp.delete();
            //helper();
        }
    }

    public List<String> spacePermutation(String input) {
        return null;
    }

    public static void main(String[] args) {
        SpacePermutation sp = new SpacePermutation();
        List<String> result = sp.permutation(new char[]{'a','b','c'});
        System.out.print(result);
    }


}
