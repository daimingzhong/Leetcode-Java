package leetcode_algorithm.class9_BackTracking;

// time : 不知道 space : 不知道

public class SudokuSolver_37 {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) { // AC
                                return true;
                            }
                            else { // Rej
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // 判断在i j上放c是不是合适。
    public boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i / 3] != '.'
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
