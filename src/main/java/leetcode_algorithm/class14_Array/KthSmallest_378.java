package leetcode_algorithm.class14_Array;

import java.util.PriorityQueue;

/**
 378. Kth Smallest Element in a Sorted Matrix

 Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 matrix =
 [[ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]],
 k = 8,

 return 13.

 [[1,2],[1,3]] 每一行 每一列排过序了。但是不完全是排好序的。
 */

public class KthSmallest_378 {
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue priorityQueue = new PriorityQueue();
        for(int row[] : matrix) {
            for(int col : row) {
                priorityQueue.offer(col);
            }
        }
        for(int i = 0; i < k - 1;i++){
            priorityQueue.poll();
        }
        return (int)priorityQueue.peek();
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{{1,2,3},{4,5,6}}, 1));
    }

}
