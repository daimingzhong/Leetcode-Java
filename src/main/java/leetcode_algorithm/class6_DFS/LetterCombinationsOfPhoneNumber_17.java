package leetcode_algorithm.class6_DFS;

/*

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.


Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber_17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[] input = digits.toCharArray();
        int[] used = new int[digits.length()];
        helper(input, 0, result, new StringBuilder(), used);
        return result;
    }

    private void helper(char[] input, int layer, List<String> result, StringBuilder sb, int[] used) {
        if(layer == input.length) {
            result.add(sb.toString());
            return;
        }
        for(int i = 0; i < input.length; i++) {
            if(used[i] == 2 || (i > 1 && input[i - 1] == input[i] )) {
                continue;
            }
            used[i]++;
            char[] cur = alpa(input[i]);
            for(char j : cur) {
                if(used[i] != 1) {
                    continue;
                }
                sb.append(j);
                helper(input, layer + 1, result, sb, used);
                sb.deleteCharAt(sb.length() - 1);
//                used[i]--;
            }
//            used[i]--;
        }
    }

    private char[] alpa(char input) {
        int i = input - '0' - 2;
        return new char[]{(char)(3*i + 'a'), (char)(3*i + 1 + 'a'), (char)(3*i + 2 + 'a')};
    }

    public static List<String> letterCombinations2(String digits) {
        String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<String>();
        if (digits.length()==0) {
            return result;
        }
        result.add("");
        for (int i=0; i<digits.length(); i++)
            result = combine(digitletter[digits.charAt(i)-'0'],result);
        return result;
    }

    public static List<String> combine(String digit, List<String> l) {
        List<String> result = new ArrayList<String>();
        for (int i=0; i<digit.length(); i++)
            for (String x : l)
                result.add(x+digit.charAt(i));
        return result;
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber_17 lc = new LetterCombinationsOfPhoneNumber_17();
        List<String> result = lc.letterCombinations("23");
        for(String s : result) {
            System.out.println(s);
        }
//        System.out.println((char)(3*2 + 'a'));
    }
}