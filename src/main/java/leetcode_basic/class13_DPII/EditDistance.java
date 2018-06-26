package leetcode_basic.class13_DPII;

/**
 * Created by Dai on 2016/12/12.  Replace, Delete, and Insert
 * string one: “sign”, string two : “asitn”
 * the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).
 *
 * 最长公共子序列（LCS）：
 * 1. 最优子结构设Xm，Yn （刻画LCS结构特征）
 *    如果Xm == Yn, Zk == Xm == Yn
 *    如果Xm != Yn && Zk != Xm , Zk是Xm-1和Yn的一个LCS
 *    如果Xm != Ym && Zk != Ym, Zk是Ym-1和Xm的一个LCS
 * 2. 一个递归解法
 *    如果Xm == Yn,子问题是Xm-1和Yn-1
 *    如果Xm != Yn，两个子问题
 * 3. 计算LCS长度（计算最优代价）
 * 4. 构造LCS（构造最优解）
 */
public class EditDistance {
    public int editDistance(String one, String two) {
        int[][] distance = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i <= one.length(); i++) {
            for (int j = 0; j <= two.length(); j++) {
                if (i == 0) {
                    distance[i][j] = j;
                }
                else if (j == 0) {
                    distance[i][j] = i;
                }
                else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                }
                else {
                    distance[i][j] = Math.min((distance[i - 1][j] + 1), distance[i][j - 1] + 1) ;
                    distance[i][j] = Math.min((distance[i - 1][j - 1] + 1), distance[i][j]) ;

                }
            }
        }
        return distance[one.length()][two.length()];
    }
    public static void main(String[] args) {
        EditDistance es = new EditDistance();
        int result = es.editDistance("abcm","dabm");
        System.out.print(result);
    }
}
