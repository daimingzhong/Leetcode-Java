package leetcode_algorithm.class12_DP;
/**
 * Implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false

 "bbarc" match = 3 sp = 3
 "*c" star = 0 pp = 1

 time : O(n)
 space : O(1)
 */


// dp

class Solution_jiu {
    public boolean isMatch(String ss, String pp) {
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        int m = s.length;
        int n = p.length;
        boolean[][] f = new boolean[m + 1][n + 1];
        int i, j;
        for (i = 0; i <= m; ++i) {
            for (j = 0; j <= n; ++j) {
                if (i == 0 && j == 0) {
                    f[i][j] = true;
                    continue;
                }

                if (j == 0) {
                    f[i][j] = false;
                    continue;
                }

                f[i][j] = false;
                if (p[j - 1] != '*') {
                    if (i > 0 && (p[j - 1] == '?' || p[j - 1] == s[i - 1])) {
                        f[i][j] = f[i-1][j-1];
                    }
                }
                else {
                    f[i][j] = f[i][j - 1];
                    if (i > 0) {
                        f[i][j] |= f[i - 1][j];
                    }
                }
            }
        }
        return f[m][n];
    }
};

public class WildcardMatching_44 {

    public boolean isMatch(String s, String p) {
        int sp = 0;  // sp is s_position ->  记录当前s的位置
        int pp = 0;  // pp is p_position -> 记录当前p的位置
        int match = 0;
        int star = -1;  // * 出现的位置
        while (sp < s.length()) {
            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                sp++;
                pp++;
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                star = pp;
                match = sp;  // 记录 s 中，第一个可以用 * 匹配的位置
                pp++;
            } else if (star != -1) {
                pp = star + 1;
                match++;
                sp = match;
            } else {
                return false;
            }
        }
        while (pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }
        return pp == p.length();
    }

    public static void main(String[] args) {
        WildcardMatching_44 wildcardMatching = new WildcardMatching_44();
        System.out.println(wildcardMatching.isMatch("bbarcc", "*c*c"));
    }
}



// 动态规划专题班记忆化搜索版本
class Solution_Jiuzhang {
    boolean[][] f;
    // done means whether f[i][j] has been calculated
    boolean[][] done;
    char[] A, B;
    int m, n;

    private void calc(int i, int j) {
        if (done[i][j]) {
            return;
        }

        done[i][j] = true;
        if (i == 0 && j == 0) {
            f[i][j] = true;
            return;
        }

        // A is not empty, B is empty
        if (j == 0) {
            f[i][j] = false;
            return;
        }

        f[i][j] = false;
        if (B[j - 1] != '*') {
            if (i > 0 && (B[j - 1] == '?' || B[j - 1] == A[i - 1])) {
                calc(i - 1, j - 1);
                f[i][j] |= f[i - 1][j - 1];
            }
        }
        else {
            // * means empty
            calc(i, j - 1);
            f[i][j] = f[i][j - 1];
            if (i > 0) {
                calc(i - 1, j);
                f[i][j] |= f[i - 1][j];
            }
        }
    }

    public boolean isMatch(String ss, String pp) {
        A = ss.toCharArray();
        B = pp.toCharArray();
        m = A.length;
        n = B.length;
        f = new boolean[m + 1][n + 1];
        done = new boolean[m + 1][n + 1];
        int i, j;
        for (i = 0; i <= m; ++i) {
            for (j = 0; j <= n; ++j) {
                done[i][j] = false;
            }
        }

        calc(m, n);
        return f[m][n];
    }
};