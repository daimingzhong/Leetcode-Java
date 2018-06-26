package leetcode_algorithm.class14_Array;

/*
695. Max Area of Island

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
connected 4-directionally (horizontal or vertical.) You may assume all four edges of the
grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
 */

// mark as used. mark with -1.
public class MaxAreaOfIsland_695 {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, helper(grid, i, j));
                }
            }
        }
        return max;
    }

    private int helper(int[][] grid, int i, int j) {
//        int tmp = 1;
//        grid[i][j] = -1;
//        if (i+1 < grid.length && grid[i+1][j] == 1) {
//            grid[i+1][j] = -1;
//            tmp += helper(grid, i+1, j) + 1;
//        }
//        if(i -1 > 0 && grid[i - 1][j] == 1) {
//            grid[i - 1][j] = -1;
//            tmp += helper(grid, i-1, j) + 1;
//        }
//        if (j + 1 < grid[0].length && grid[i][j+1] == 1) {
//            grid[i][j+1] = -1;
//            tmp += helper(grid, i, j + 1) + 1;
//        }
//        if(j - 1 > 0 && grid[i][j-1] == 1) {
//            grid[i][j-1] = -1;
//            tmp += helper(grid, i, j - 1) + 1;
//        }
//        return tmp;
        // 这里直接写i, j 就可以了，因为之后会做判断。
        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + helper(grid, i+1, j) + helper(grid, i-1, j) + helper(grid, i, j-1) + helper(grid, i, j+1);
        }
        return 0;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland_695 mx = new MaxAreaOfIsland_695();
        System.out.println(mx.maxAreaOfIsland(new int[][]{{0,1},{1,1}}));
    }
}
