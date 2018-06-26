package leetcode_algorithm.class9_BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * time : O(3^n)
 * space : O(n)
 */

public class LetterCombinationOfPhoneNumber_17 {

    private String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(res, digits, "", 0);
        return res;
    }


    // 通过index控制每个for 进入下一个单词。 for里面是处理了一个单词。
    public void helper(List<String> res, String digits, String s, int index) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            helper(res, digits, s + letters.charAt(i), index + 1);
        }
    }


    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper2(res, digits, new StringBuilder(), 0);
        return res;
    }

    public void helper2(List<String> res, String digits, StringBuilder cur, int index) {
        if (index == digits.length()) {
            res.add(cur.toString());
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            helper2(res, digits, cur.append(letters.charAt(i)), index + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public List<String> letterCombinations3(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            while (res.peek().length() == i) {
                String t = res.remove();
                for (char s : mapping[num].toCharArray()) {
                    res.add(t + s);
                }
            }
        }
//        List<Integer> temp = new ArrayList<>();
//        temp.set();
        return res;
    }

    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber_17 letterCombinationOfPhoneNumber_17 = new LetterCombinationOfPhoneNumber_17();
        List<String> res = letterCombinationOfPhoneNumber_17.letterCombinations("23");
        List<String> res2 = letterCombinationOfPhoneNumber_17.letterCombinations2("23");
        System.out.println(10);
    }
}
