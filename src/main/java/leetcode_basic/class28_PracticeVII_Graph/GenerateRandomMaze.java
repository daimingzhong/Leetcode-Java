package leetcode_basic.class28_PracticeVII_Graph;

public class GenerateRandomMaze {

    public int[][] maze(int n ) {
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    maze[i][j] = 0;
                } else {
                    maze[i][j] = 1;
                }
            }
        }
        generate(maze, 0, 0);
        return maze;
    }

    private void generate(int[][] maze, int x, int y) {
        Dir[] dirs = Dir.values();
        shuffle(dirs);
        for (Dir dir : dirs) {
            int nextX = dir.moveX(x, 2);
            int nextY = dir.moveY(y ,2);
            if (isValidWall(maze, nextX, nextY)) {
                maze[dir.moveX(x, 1)][dir.moveY(y, 1)] = 0;
                maze[nextX][nextY] = 0;
                generate(maze, nextX, nextY);
            }
        }
    }

    private void shuffle(Dir[] dirs) {
        for (int i = 0; i < dirs.length; i++) {
            int index = (int)(Math.random() * (dirs.length - i));
            Dir tmp = dirs[i];
            dirs[i] = dirs[i + index];
            dirs[i + index] = tmp;
        }
    }

    private boolean isValidWall(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >=0 && y < maze[0].length && maze[x][y] == 1;
    }

    enum Dir {
        NORTH(-1, 0), SOUTH(1, 0), EAST(0, -1), WEST(0, 1);
        int deltaX;
        int deltaY;

        Dir(int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }

        public int moveX(int x, int times) {
            return x + times * deltaX;
        }

        public int moveY(int y, int times) {
            return y + times * deltaY;
        }
    }

    public static void main(String[] args) {
        GenerateRandomMaze generateRandomMaze = new GenerateRandomMaze();
        int[][] res = generateRandomMaze.maze(5);
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println(" ");
        }
    }
}
