package leetcode_basic.class10_Recursion;

import java.util.Arrays;

/**
 * Created by Dai on 2016/12/10.
 * M = 3, N = 4
 * The generated matrix is
 * { {1,  2,  3,  4}
 *   {10, 11, 12, 5},
 *   {9,  8,  7,  6}
 *  }
 *
 */
public class SpiralOrderGenerateII {
    public int[][] spiralGenerate(int m, int n) {
        int[][] matrix = new int[m][n];
        help(matrix, m, n);
        return matrix;
    }


    private void help(int[][] matrix, int m,int n) {
        if (m == 0 || n == 0) {
            return;
        }
        int num = 1;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1 ;
        // three base cases
        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                matrix[up][i] = num++;
            }
            for (int i = up + 1; i <= down - 1; i++) {
                matrix[i][right] = num++;
            }
            for (int i = right; i >= left; i--) {
                matrix[down][i] = num++;
            }
            for (int i = down - 1; i >= up + 1; i--) {
                matrix[i][left] = num++;
            }
            left++;
            right--;
            up++;
            down--;
        }
        if (left > right || up > down) {
            return;
        }
        if(left == right) {
            for (int i = up; i <= down; i++) {
                matrix[i][left] = num++;
            }
        }
        else {
            for (int i = left; i <= right; i++) {
                matrix[up][i] = num++;
            }
        }
    }

    public static void main (String[] args) {
        SpiralOrderGenerateII sp = new SpiralOrderGenerateII();
        int[][] matrix = sp.spiralGenerate(3,4);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i])); // 打印二维数组
        }
    }

}
