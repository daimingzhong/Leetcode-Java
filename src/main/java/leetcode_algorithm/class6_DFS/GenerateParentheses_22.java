package leetcode_algorithm.class6_DFS;

import java.util.ArrayList;
import java.util.List;

/*

22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

in total 6 layers.

 ( ( ( shall be less than 3.

15:34 - 16：18
第一种方法还是不对。


 */
public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
//        helper(n, 0, 0, result, new StringBuilder());
        helper2(n, 0, 0, result, new String());
        return result;
    }

    private void helper(int n, int left, int right, List<String> result, StringBuilder sb) {
        if(left > right) {
            return;
        }
        if(left + right == n * 2) {
            result.add(new StringBuilder(sb).toString());
            sb = new StringBuilder();
            return;
        }
        if(left < n) {
            sb.append('(');
        }
        helper(n, left + 1, right, result, sb);
        if(right < left) {
            sb.append(')');
        }
        helper(n, left, right + 1, result, sb);
        sb.deleteCharAt(sb.length() - 1);

    }

    private void helper2(int n, int left, int right, List<String> result, String cur) {
        if(left + right == n * 2) {
            result.add(cur);
            return;
        }
        if(left < n) {
            helper2(n, left + 1, right, result, cur + '(');
        }
        if(right < left) {
            helper2(n, left, right + 1, result, cur + ')');
        }
    }


    public static void main(String[] args) {
        GenerateParentheses_22 gp = new GenerateParentheses_22();
        List<String> result = gp.generateParenthesis(3);
        for(String tmp :result) {
            System.out.println(tmp);
        }
    }
}