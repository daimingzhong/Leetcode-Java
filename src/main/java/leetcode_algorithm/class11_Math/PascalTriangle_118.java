package leetcode_algorithm.class11_Math;
/*

118. Pascal's Triangle

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],         0
    [1,1],        1
   [1,2,1],       2
  [1,3,3,1],      3   b
 [1,4,6,4,1]      4   a = b[0] + b[1],  b[1] + b[2], ..... b[length - 2] + b[length - 1]
]

                        1
                      1   1
                    1   2   1
                  1

  the most left element is 1. the second one is the sum of (0, 1).
  the third is sum of element (1 + 2)
  the last one is 1.
  from the 3rd layer:

  add(1)
  mid nums is 3-2 = 1.
  add(1)

 */

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        if (numRows == 0) {
            return  result;
        }
        result.add(new ArrayList<>(cur));
        if(numRows == 1) {
            return result;
        }
        cur.add(1);
        result.add(cur);
        if(numRows == 2) {
            return result;
        }
        for (int i = 2; i < numRows; i++) {
            cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                List<Integer> prev = result.get(i - 1);
                if (j == 0) {
                    cur.add(1);
                } else if (j < i) {
                    cur.add(j, prev.get(j - 1) + prev.get(j));
                } else {
                    cur.add(i, 1);
                }
            }
            result.add(cur);
        }
        return result;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }
    public static void main(String[] args) {
           PascalTriangle_118 ps = new PascalTriangle_118();
           List<List<Integer>> result = ps.generate(5);
           for(List i : result) {
               System.out.println(i);
           }
    }
}