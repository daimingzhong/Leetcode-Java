package leetcode_algorithm.class9_BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 * time : O(n^n) 不是很确定
 * space : O(n)

 */


public class NQueens_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        helper(res, new int[n], 0);
        return res;
    }

    public void helper(List<List<String>> res, int[] queens, int pos) {
        if (pos == queens.length) {
            addSolution(res, queens);
            return;
        }
        for (int i = 0; i < queens.length; i++) {
            queens[pos] = i;
            if (isValid(queens, pos)) {
                helper(res, queens, pos + 1);
            }
        }
    }

    public boolean isValid(int[] queens, int pos) {
        for (int i = 0; i < pos; i++) {
            if (queens[i] == queens[pos]) { // 同一列
                return false;
            } else if (Math.abs(queens[pos] - queens[i]) == Math.abs(i - pos)) { //是否在对角线上
                return false;
            }
        }
        return true;
    }

    public void addSolution(List<List<String>> res, int[] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (queens[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }

    public static void main(String[] args) {
        NQueens_51 nQueens_51 = new NQueens_51();
        int n = 4;
        List<List<String>> res = nQueens_51.solveNQueens(n);
        for (List<String> list : res) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            System.out.println("");
        }
    }
}
