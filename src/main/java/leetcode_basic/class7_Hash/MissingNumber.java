package leetcode_basic.class7_Hash;

import java.util.HashSet;

/**
 * Created by Dai on 2016/12/7.
 * A = {2, 1, 4}, the missing number is 3
 * A = {1, 2, 3}, the missing number is 4
 * A = {}, the missing number is 1
 */

public class MissingNumber {
    public int missing(int[] array) {
        int n = array.length + 1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }
        for (int i = 1; i < n; i++) {
            if (!set.contains(i)) {
                return i;
            }
            else {
                return i;
            }
        }
        return  n;
     }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int result = mn.missing(new int[]{});
        System.out.println(result);
    }
}
