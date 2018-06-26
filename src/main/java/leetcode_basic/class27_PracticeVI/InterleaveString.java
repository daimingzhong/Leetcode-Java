package leetcode_basic.class27_PracticeVI;

public class InterleaveString {
    public boolean canMerge(String a, String b, String c) {
        int alen = a.length();
        int blen = b.length();
        int clen = c.length();
        if (alen + blen != clen) {
            return false;
        }
        boolean[][] canMerge = new boolean[alen + 1][blen + 1];
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0 && j == 0) {
                    canMerge[i][j] = true;
                }
                if (i > 0 && a.charAt(i - 1) == c.charAt(i + j - 1)){
                    canMerge[i][j] |= canMerge[i - 1][j];
                }
                if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1)) {
                    canMerge[i][j] |= canMerge[i][j - 1];
                }
            }
        }
        return canMerge[alen][blen];
    }

    public static void main(String[] args) {
        InterleaveString interleaveString = new InterleaveString();
        boolean res = interleaveString.canMerge("ab", "cd", "acbd");
        System.out.println(res);
    }
}
