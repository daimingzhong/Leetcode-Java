package leetcode_basic.class11_Math;

/**
 * Created by Dai on 2016/12/1.
 We are using ASCII charset, the value of valid characters are from 0 to 255 The given string is not null
  all the characters in "abA+\8" are unique
 "abA+\a88" contains duplicate characters
 */
public class AllUniqueCharsII {
    private boolean allUnique(String word) {
        // each int value can represent 32 bits. so we need 8 ints to represent 256 bits
        int[] vec = new int[8];
        char[] array = word.toCharArray();
        for (char c : array) {
            // for a value c in range 0-255,
            // map to int value at c/32 as index, and the c%32 th bit of the int value
            if ((vec[c/32] >>> (c % 32) & 1) != 0) {
                return false;
            }
            vec[c/32] |= 1 << (c % 32);
        }
        return true;
    }
    public static void main(String[] args) {
        AllUniqueCharsII au = new AllUniqueCharsII();
        String word = "aba";
        System.out.println(au.allUnique(word));
//        System.out.println((int)'a');
//        System.out.println('a'/32);
//        System.out.println('a'% 32);
    }
}