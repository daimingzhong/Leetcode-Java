package leetcode_algorithm.class14_Array;

/*
624. Maximum Distance in Arrays
Given m arrays, and each array is sorted in ascending order.
Now you can pick up two integers from two different arrays
(each array picks one) and calculate the distance.
We define the distance between two integers a and b to be their
absolute difference |a-b|. Your task is to find the maximum distance.

Example 1:
Input:
[[1,2,3],
 [4,5],
 [1,2,3]]
Output: 4
Explanation:
One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.


// 防止和自己产生交集：先运算，再更新。只看前半部分。和two sum类似，防止用到自己。
 */

import java.util.List;

public class MaximumDistanceInArrays_624 {
    public int maxDistance(List<List<Integer>> arrays) {
        if(arrays.size() <= 1) {
            return 0;
        }
        int max = 0;
        for(int i = 0; i < arrays.size(); i++) {
            for (int j = 0; j < arrays.size(); j++) {
                if(i != j) {
                    List<Integer> l1 = arrays.get(i);
                    List<Integer> l2 = arrays.get(j);
                    int tmp = Math.max(Math.abs(l1.get(0) - l2.get(l2.size() - 1)),
                            Math.abs(l1.get(l1.size() - 1) - l2.get(0)));
                    max = Math.max(tmp, max);
                }
            }
        }
        return max;
    }


    public int maxDistance2(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);

        for (int i = 1; i < arrays.size(); i++) {
            result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));
            result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumDistanceInArrays_624 mx = new MaximumDistanceInArrays_624();
//        new [[-1,5],[1,4,6],[4,5,6]]
//        mx.maxDistance(new L)
    }

}