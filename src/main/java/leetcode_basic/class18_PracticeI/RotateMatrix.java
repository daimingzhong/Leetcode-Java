package leetcode_basic.class18_PracticeI;

import java.util.Arrays;

/**
 * Created by Dai on 2016/12/28
 * Rotate an N * N matrix clockwise 90 degrees.
 * Assumptions
 * The matrix is not null and N >= 0
 * Examples
 { {1,  2,  3}
   {8,  9,  4},
   {7,  6,  5} }

 after rotation is
 { {7,  8,  1}
   {6,  9,  2},
   {5,  4,  3} }

 */
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) { // y = - x 翻转
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < matrix.length; i++) { //沿着中间竖线翻转
            for (int j = 0; j < matrix[0].length/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - j - 1];
                matrix[i][matrix[0].length - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        RotateMatrix rm = new RotateMatrix();
        int[][] matrix = new int[][]{{1,2,3},{8,9,4},{7,6,5}};
        rm.rotate(matrix);
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
    }
}