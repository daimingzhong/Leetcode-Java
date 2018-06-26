package leetcode_basic.class10_Recursion;

import leetcode_basic.class0.Cell;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {
    public int kthSmallest(int[] A , int[] B, int k) {
        PriorityQueue<Cell> maxheap = new PriorityQueue<Cell>(2, new Comparator<Cell>() {
            @Override
            public  int compare(Cell c1, Cell c2) {
                int sum1 = A[c1.aldx] + B[c1.bldx] ;
                int sum2 = A[c2.aldx] + B[c2.bldx] ;
                if (sum1 == sum2) {
                    return 0;
                }
                return sum1 > sum2 ? -1:1;
            }
        });
        maxheap.offer(new Cell(0,0));
        boolean[][] visited = new boolean[A.length][B.length];
        visited[0][0] = true;
        for (int i = 0; i<= k-1; i++) {
            Cell tmp = maxheap.poll();
            if (tmp.aldx+1  < A.length && !visited[tmp.aldx+1][tmp.bldx]) {
                visited[tmp.aldx+1][tmp.bldx] = true;
                maxheap.offer(new Cell(tmp.aldx+1, tmp.bldx));
            }
            if (tmp.bldx+1 < B.length && !visited[tmp.aldx][tmp.bldx+1]) {
                visited[tmp.aldx][tmp.bldx+1] = true;
                maxheap.offer(new Cell(tmp.aldx, tmp.bldx+1));
            }
        }
        Cell res = maxheap.poll();
        return A[res.aldx] + B[res.bldx] ;
    }

     public static void main (String[] args) {
         int[] A = {1,2,3};
         int[] B = {6,13};
         int k = 2;
         KthSmallest kth = new KthSmallest();
         System.out.println(kth.kthSmallest(A,B,k));
     }

}
