package leetcode_basic.class10_Recursion;

import java.util.ArrayList;
import java.util.List;

/*
helper为什么要写到for里面。
 */

public class NQueens {
    public List<List<Integer>> nQueens(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curLayer = new ArrayList<Integer>();
        helper (n, curLayer, result);
        return result;
    }
    private void helper (int n, List<Integer> curLayer, List<List<Integer>> result) {
        if (curLayer.size() == n) {
            result.add(new ArrayList<Integer>(curLayer));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (checkValid (curLayer, i)) {
                curLayer.add(i);
                // 对于每一个当前空格，都有n中放法，都要遍历一遍。
                // 推动是靠i，i表示n中放法的具体位置
                // remove，到最深的地方，返回，需要删掉刚刚加的
                helper(n, curLayer, result);
                curLayer.remove(curLayer.size() - 1);
            }
        }
    }
    // take n times to check whether available.
    private boolean checkValid (List<Integer> curLayer, int column) {
        int row = curLayer.size();
        for (int i =0; i < row; i++) {
            if (curLayer.get(i) == column || Math.abs (curLayer.get(i) - column) == row - i ) {
                return false;
            }
        }
        return true;
    }
    public static void main (String[] args) {
        NQueens nq = new NQueens();
        List<List<Integer>> a = nq.nQueens(4);
        int k = 0;
        for (List<Integer> i: a) {
            System.out.println(i);
            k++;
        }
        System.out.println(k);
    }

}

