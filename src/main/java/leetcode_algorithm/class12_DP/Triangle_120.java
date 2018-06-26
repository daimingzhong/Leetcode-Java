package leetcode_algorithm.class12_DP;

/*

120. Triangle

Given a triangle, find the minimum path sum from top to bottom.
Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
 [0,0,0,0,0]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 */


import java.util.ArrayList;
import java.util.List;

public class Triangle_120 {

    private int min = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
         if(triangle == null) {
             return 0;
         }
         helper(triangle, 0, 0, 0);
         return min;
    }

    private void helper(List<List<Integer>> input, int layer, int index, int tmp) {
        if(layer == input.size() - 1) {
            int res = tmp + input.get(layer).get(index);
            min = Math.min(res, min);
            return;
        }
        helper(input, layer + 1, index, tmp + input.get(layer).get(index));
        helper(input, layer + 1, index + 1, tmp + input.get(layer).get(index));
    }

    public int minimumTotal2(List<List<Integer>> triangle) { // 从下往上传。
        int len = triangle.size();
        int[] dp = new int[len];
        for(int i = len-1;i >= 0; i--){
            for(int j = 0; j <= i; j++){
                if(i == len-1) dp[j]= triangle.get(i).get(j);
                else{
                    dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Triangle_120 ta = new Triangle_120();
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(2);
        input.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(3);tmp.add(4);
        input.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(6); tmp.add(5); tmp.add(7);
        input.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(4); tmp.add(1); tmp.add(8); tmp.add(3);
        input.add(tmp);
        System.out.println(ta.minimumTotal2(input));
    }
}
