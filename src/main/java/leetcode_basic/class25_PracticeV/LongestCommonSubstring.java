package leetcode_basic.class25_PracticeV;

/**
 * Created by Dai on 2017/1/4.
 * S = “abcde”, T = “cdf”, the longest common substring of S and T is “cd”
 * edit distance可以的操作，删除，增加，替换
每次加一个进来，有三种可能
 1. 前一个s中出了问题，忽略s的一个数。相当于s中删除一个，或者t中增加一个
 2. 前一个t中出了问题，忽略t中的一个数，相当于t中删除一个。
 3. 前一个s，t都出了问题，相当于一起忽略s和t，或者替换。
 4. 这种可能是不需要操作，前一个是最优解，当前也是最优解。// 这四种都假设前一个解是最优解
 // 把所有可能的情况列下来，代码就好写了。


 lcs, 最长共同子序列1
 1.

 */
public class LongestCommonSubstring {
    public String longestCommon(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length()+ 1];
        int startTmp = 0, start = 0, end = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    max = Math.max(dp[i + 1][j + 1], max);
                    if (dp[i + 1][j + 1] == 1) {
                        startTmp = i;
                    }
                    if (dp[i + 1][j + 1] == max) {
                        end = i + 1;
                        start = startTmp;
                    }
                }
                else{
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j],dp[i][j + 1]);
                }
            }
        }
        return s.substring(start,end);
    }

    public int longestCommonLength(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length()+ 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                else{
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j],dp[i][j + 1]);
                }
            }
        }
        return dp[s.length()][t.length()];
    }
    public static void main(String[] args) {
        LongestCommonSubstring ls = new LongestCommonSubstring();
        //int result = ls.longestCommonLength("abcde","cdf");
        //System.out.print(result);
        String res = ls.longestCommon("ab","abc");
        System.out.print(res);
    }
}
