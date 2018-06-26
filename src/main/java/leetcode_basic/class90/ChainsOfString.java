package leetcode_basic.class90;

/**
 * Created by Dai on 2017/1/4.
 Given an array of strings, find if all the strings can be chained to form a circle.
 For example,   “abc” and “cd” can be chained,
 “abc” and “dz” can not be chained.

 Example Input: arr[] = {"aaa", "bbb", "baa", "aab"};
 Output: True,
 */

// Brute force way: find all the permutations, and check for each two pairs. If there exists a combination that each of them can be chained, then output true.
// time complexity O(n! * n) or O(n!) space complexity O(n)
// not that good.

public class ChainsOfString {
    // Form the permutation by dfs
    public boolean isCircle(String[] input) {
        //
        if (input == null || input.length == 0) {
            return false;
        }
        if (input.length == 1) {
            return input[0].charAt(0) == input[0].charAt(input[0].length() - 1);
        }
        boolean[] flag = new boolean[1];
        helper(input, flag, 0);
        return flag[0];
    }

    private boolean helper(String[] input, boolean[] flag, int level) {
        if (level == input.length) {
            String first = input[0];
            String last = input[input.length - 1];
            if(last.charAt(last.length() - 1) == first.charAt(0)) {
                return true;
            }
            return false;
        }
        for (int i = level; i < input.length; i++) {
            if (level == 0 || input[i].charAt(0) == input[level - 1].charAt(input[level - 1].length() - 1)) {
                swap(input, level , i);
                if (helper(input, flag, level + 1)) {
                    return true;
                }
                swap(input, level, i);
            }
        }
        return true;
    }

    private void swap (String[] input,int level, int i) {
        String tmp = input[level];
        input[level] = input[i];
        input[i] = input[level];
    }

    public static void main(String[] args) {
        ChainsOfString cs = new ChainsOfString();
        boolean result = cs.isCircle(new String[]{"abc","cba"});//,"cde","dea"
        System.out.print(result);
    }
}
