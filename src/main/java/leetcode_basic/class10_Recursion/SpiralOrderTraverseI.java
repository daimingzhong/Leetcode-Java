package leetcode_basic.class10_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dai on 2016/12/9.
 * The 2D array is not null and has size of N * N where N >= 0
 * { {1,  2,  3},
    {4,  5,  6},
    {7,  8,  9} }
 the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
 */
public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        recursiveTraverse(matrix, 0, matrix.length, list);
        return list;
    }
    private void recursiveTraverse(int[][] matrix, int offset, int size, List<Integer> result){
        if (size == 0) {
            return;
        }
        if (size == 1) {
            result.add(matrix[offset][offset]);
            return;
        }
        // 分成四段，每段都相等。1,2，然后3,6，然后9,8，然后7,4。size == 1的时候，说明只剩5了
        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset + i][size + offset - 1]);
        }
        for (int i = size - 1; i >= 1; i--) {
            result.add(matrix[offset + size - 1][offset + i]);
        }
        for (int i = size - 1; i >= 1; i--) {
            result.add(matrix[offset + i][offset]);
        }
        // 先引用，再递归。尾递归。因为递归的结果对前面没有影响。这里最外层写个for也一样。
        recursiveTraverse(matrix, offset + 1, size - 2, result);
    }

    public static void main (String[] args) {
        SpiralOrderTraverseI sp = new SpiralOrderTraverseI();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.println(Arrays.toString(matrix[i])); // 打印二维数组
        }
        System.out.println(sp.spiral(matrix));
    }
}