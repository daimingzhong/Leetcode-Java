package leetcode_algorithm.class9_BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations_77
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

 time : O(n^min{k,n-k})
 space : O(n);
 http://stackoverflow.com/questions/31120402/complexity-when-generating-all-combinations
 */


public class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, k, 1);  // n = 4, k = 2.
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(res, list, n, k - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public void helper2(List<List<Integer>> res, List<Integer> list, int n, int k, int count, int start) {  // n = 4, k = 2
        if (count == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper2(res, list, n, k, count++, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, k, 1);  // n = 4, k = 2.
        return res;
    }

    public static void main(String[] args) {
        Combinations_77 combinations_77 = new Combinations_77();
        List<List<Integer>> res = combinations_77.combine2(4,2);
        System.out.println(10);
    }
}
