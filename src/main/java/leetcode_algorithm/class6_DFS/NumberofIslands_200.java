package leetcode_algorithm.class6_DFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011

 father
 01
 56

 51
 50
 ..

 Answer: 3

 time : O(m * n)
 space : O(n)

 */

public class NumberofIslands_200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }

    public int numIslands2(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; i++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int n = grid.length;
        int m = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int code = x * m + y;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int i = code / m;
            int j = code % m;
            if (i > 0 && grid[i - 1][j] == '1') {
                queue.offer((i - 1) * m + j);
                grid[i - 1][j] = '0';
            }
            if (i < n - 1 && grid[i + 1][j] == '1') {
                queue.offer((i + 1) * m + j);
                grid[i + 1][j] = '0';
            }
            if (j > 0 && grid[i][j - 1] == '1') {
                queue.offer((i * m) + j - 1);
                grid[i][j - 1] = '0';
            }
            if (j < m - 1 && grid[i][j + 1] == '1') {
                queue.offer((i * m) + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }

    public static void main(String[] args) {
        NumberofIslands_200 numberofIslands_200 = new NumberofIslands_200();
        char[][] input = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        /*
         11000
         11000
         00100
         00011
         */
        int res = numberofIslands_200.numIslands(input);
        System.out.println(res);
    }
}
