package leetcode_basic.class6_DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dai on 2017/1/19.
 N = 1, all valid permutations are ["()"]
 N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
 N = 0, all valid permutations are [""]

 1.  一共多少层，6层。每层要保存什么信息，左右分别用了多少个，有没有达到最后呢。
2. 每一层有两种选择。这两种选择有要求。
 */
public class AllValidPermutationsOfParenthesesI {
    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            result.add(new String());
            return result;
        }
        StringBuilder cur = new StringBuilder();
        int left, right;
        left = right = 0;
        helper(0,n,left, right, cur, result);
        return result;
    }
    private void helper(int level, int n,int left, int right, StringBuilder cur, List<String> result) {
        if (level == n * 2 ) {
            if (left == right){
                result.add(cur.toString());
            }
            return;
        }
        if (left >= right) { // 在这里剪枝，不然最后判断比较麻烦。
            cur.append('(');
            helper(level+1, n, left+1, right, cur, result);// 递归的前后，cur都没变，递归相当于黑箱操作。
            cur.deleteCharAt(cur.length() - 1);
        }
        if (left > right) {
            cur.append(')');
            helper(level + 1, n,left, right + 1, cur, result);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        AllValidPermutationsOfParenthesesI av = new AllValidPermutationsOfParenthesesI();
        List<String> result = av.validParentheses(0);
        for (String s : result) {
            System.out.println(s);
        }

    }

}
