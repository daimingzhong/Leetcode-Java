package leetcode_basic.class8_String;

import java.util.Arrays;

/**
 * Created by Dai on 2016/12/8.
 * { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
 * { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
 */
public class ReorderArray {
    public int[] reorder(int[] array) {
        if(array.length == 0) {
            return array;
        }
        int[] input = new int[array.length];
        for(int i = 0; i <= array.length/2 - 1; i++) {
            input[i*2] = array[i];
            input[i*2 + 1] = array[array.length/2 + i];
        }
        input[input.length - 1] = array[array.length - 1];
        return input;
    }
    public static void main (String[] args) {
        ReorderArray ra = new ReorderArray();
        System.out.print(Arrays.toString(ra.reorder(new int[]{ 1 })));
    }
}
