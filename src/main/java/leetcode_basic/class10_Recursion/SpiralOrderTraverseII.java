package leetcode_basic.class10_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dai on 2016/12/10.
 * { {1,  2,  3,  4},
 *   {5,  6,  7,  8},
 *   {9, 10, 11, 12} }
 *  the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
 */
public class SpiralOrderTraverseII {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        recursiveTraverse(matrix, result);
        return result;
    }
    private void recursiveTraverse2(int[][] matrix , int offset, int lengthX, int lengthY, List<Integer> result) {
        // 用递归写
        if (lengthX == 0 && lengthY == 0) {
            return;
        }
        if (lengthX != 0 && lengthY ==0) {
            result.add(matrix[offset][offset]);
        }
        for (int i = 0; i < lengthX ;  ) {

        }
    }

    private void recursiveTraverse(int[][] matrix , List<Integer> list) {
        // 用循环写
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1 ;
        // three base cases
        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down - 1; i++) {
                list.add(matrix[i][right]);
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1; i--) {
                list.add(matrix[i][left]);
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
                list.add(matrix[i][left]);
            }
        }
        else {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
        }
        return;
    }

    public static void main (String[] args) {
        SpiralOrderTraverseII sp = new SpiralOrderTraverseII();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i])); // 打印二维数组
        }
        System.out.println(sp.spiral(matrix));
    }


}
