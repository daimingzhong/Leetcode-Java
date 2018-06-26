package leetcode_algorithm.class11_Math;

/*
119. Pascal's Triangle II

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        if (rowIndex == 0) {
            return  new ArrayList<>();
        }
        if(rowIndex == 1) {
            prev.add(1);
            return prev;
        }
        if(rowIndex == 2) {
            prev.add(1);
            return prev;
        }
//        for (int i = 2; i < rowIndex; i++) {
//            cur = new ArrayList<>();
//            for (int j = 0; j <= i; j++) {
//                List<Integer> prev = result.get(i - 1);
//                if (j == 0) {
//                    cur.add(1);
//                } else if (j < i) {
//                    cur.add(j, prev.get(j - 1) + prev.get(j));
//                } else {
//                    cur.add(i, 1);
//                }
//            }
//            result.add(cur);
//        }
        return cur;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int row = 0; row <= rowIndex; row++) {
            ret.add(0, 1);
            for (int i = 1; i < row; i++)
                ret.set(i, ret.get(i) + ret.get(i + 1));
        }
        return ret;
    }

    public static void main(String[] args) {
        PascalTriangleII_119 ps = new PascalTriangleII_119();
        List<Integer> result = ps.getRow2(0);
        System.out.println(result);
    }
}