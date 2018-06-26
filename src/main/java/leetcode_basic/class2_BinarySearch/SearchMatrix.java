package leetcode_basic.class2_BinarySearch;

import java.util.Arrays;

/**
 * Created by Dai on 2016/11/26.
 * matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }

 target = 7, return {1, 2}

 target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
 */
public class SearchMatrix {
    public int[] search(int[][] matrix, int target) {
        int[] result = new int[] {-1, -1};
        if (matrix.length == 0 || matrix[0].length ==0) {
            return result;
        }
        int row = findRow(matrix, target) ;
        if (row == -1) {
            return result;
        }
        int col = findCol(matrix, row, target) ;
        if (col == -1) {
            return result;
        }
        else {
            result[0] = row;
            result[1] = col;
            return result;
        }
    }

    // find the largest row with first element  <= target
    private int findRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right -1) {
            int mid = left + (right - left) / 2 ;
            if (matrix[mid][0] <= target ) {
                left = mid;
            }
            else if (matrix[mid][0] > target) {
                right = mid;
            }
        }
        if (matrix[right][0] <= target) {
            return right;
        }
        else {
            return left;
        }
    }

    private int findCol(int[][] matrix, int col, int target) {
        int left = 0;
        int right = matrix[0].length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2 ;
            if (matrix[col][mid] <= target ) {
                left = mid;
            }
            else if (matrix[col][mid] > target) {
                right = mid;
            }
        }
        if (matrix[col][left] == target) {
            return left;
        }
        else if (matrix[col][right] == target) {
            return right;
        }
        else {
            return -1;
        }
    }

    public static void main (String[] args) {
        int[][] matrix = {{1,2,3,4}};
        SearchMatrix sm = new SearchMatrix();
        int[] result =sm.search(matrix,4);
        System.out.println(Arrays.toString(result));
    }
}
