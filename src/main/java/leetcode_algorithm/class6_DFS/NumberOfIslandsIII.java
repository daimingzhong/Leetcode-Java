package leetcode_algorithm.class6_DFS;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsIII {
    public List<Integer> numIslands(char[][] grid, int target) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int[] curCount = {0};
                    dfs(grid, i, j, curCount);
                    res.add(curCount[0]);
                    curCount[0] = 0;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j, int[] curCount) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        } else {
            curCount[0]++;
        }
        grid[i][j] = '0';
        dfs(grid, i, j + 1, curCount);
        dfs(grid, i, j - 1, curCount);
        dfs(grid, i + 1, j, curCount);
        dfs(grid, i - 1, j, curCount);
    }

    public static void main(String[] args) {
        NumberOfIslandsIII numberofIslandsIII = new NumberOfIslandsIII();
        char[][] input = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        /*
         11000
         11000
         00100
         00010
         */
        List<Integer> res = numberofIslandsIII.numIslands(input, 1);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
