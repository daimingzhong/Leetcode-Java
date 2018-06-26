package leetcode_basic.class5_BFS;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * { {1,  3,   5,  7},

 {2,  4,   8,   9},

 {3,  5, 11, 15},

 {6,  8, 13, 18} }

 the 5th smallest number is 4
 the 8th smallest number is 6

 */
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        boolean[][] visited = new boolean[row][col];
        minHeap.offer(new Cell(0,0,matrix[0][0]));
        visited[0][0] = true;
        for (int i = 0; i < k-1; i++) {
            Cell cur = minHeap.poll();
            if (cur.row + 1 < row && !visited[cur.row + 1][cur.col]) {
                minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
                visited[cur.row + 1][cur.col] = true;
            }
            if (cur.col + 1 < col && !visited[cur.row][cur.col + 1]) {
                minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
                visited[cur.row][cur.col + 1] = true;
            }
        }
        return minHeap.peek().value;
    }


    static class Cell {
        int row;
        int col;
        int value;
        Cell (int row, int col, int value) {
            this.row = row;
            // 这个this.row是member variable，区别于contructer里的row，
            // 除了this，在类内部，要写Cell.row 而且还必须是static的row
            this.col = col;
            this.value = value;
        }
    }

    public static void main (String[] args) {
        int[][] a  = { {1,  3,   5,  7}, {2,  4,   8,   9}, {3,  5, 11, 15}, {6,  8, 13, 18} };
        KthSmallest ks = new KthSmallest();
        System.out.println(ks.kthSmallest(a,8));
    }
}
