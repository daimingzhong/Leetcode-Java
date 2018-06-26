package leetcode_basic.class20_Mid;

/**
 * Created by Dai on 2016/12/17.
 * Created by Dai on 2016/11/15.
 * “a | babbbab | bab | aba” is a palindrome partitioning of “ababbbabbababa”.
 *  The minimum number of cuts needed is 3.
 */
public class MinCutPalindrome {
        public int minCut (String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int N = s.length();
            int[] cut = new int[N];
            for (int i = 0; i < N; i++) {   // add 1 letter at a time
                cut[i] = i;
                if (isPal (s, 0, i)) {
                    cut[i] = 0;
                    continue; // 跳出本次循环
                }
                for (int j = i - 1; j >= 0; j--) {  // 回头看is here
                    if (isPal(s, j + 1, i)) {  // check 右小段
                        cut[i] = Math.min(cut[i], cut[j] + 1);
                    }
                }
            }
            return cut[N - 1];
        }

        private boolean isPal(String s, int l, int h) {
            while (l < h) {
                if (s.charAt(l++) != s.charAt(h--)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public static void main (String[] args) {
            MinCutPalindrome mc = new MinCutPalindrome();
            int nums = mc.minCut("abcbd");
            System.out.println(nums);
        }
}

