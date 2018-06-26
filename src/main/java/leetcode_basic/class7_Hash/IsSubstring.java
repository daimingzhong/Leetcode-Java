package leetcode_basic.class7_Hash;

/**
 * Created by Dai on 2016/12/5.
 * “ab” is a substring of “bcabc”, return 2
 * “bcd” is not a substring of “bcabc”, return -1
 *  "" is substring of "abc", return 0
 */

public class IsSubstring {
    public int strstr(String large, String small) {
        if (large.length() < small.length()) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= large.length() - small.length(); i++) {
            if (equals(large, i, small)) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(String  large, int start, String small) {
        // for 执行完语句之后，加一返回for。所以最终是满足 i < small.lenght()的最后一次就结束了。也就是 == length -1
        for (int i = 0; i < small.length(); i++) { // 这里i = start，起始条件都能错， 终止条件也写错了。
            char a = small.charAt(i);
            if (small.charAt(i) != large.charAt(i + start)) {
                return false;
            }
        }
        return true;
    }

    public int isSubstring2(String large, String small) {          // rabin - kap algorithm
        if (large.length() < small.length()) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }

        int largePrime = 101;
        int smallPrime = 31;
        int seed = 1;

        int targetHash = small.charAt(0) % largePrime;
        // 先算出短的target。
        // "bcd". 98 +

        for (int i = 1; i < small.length(); i++) {
            seed = moduleHash(seed, 0, smallPrime, largePrime);  // seed是给后面用的，这里只用了modulehash，就是膜hash。
            targetHash = moduleHash(targetHash, small.charAt(i),smallPrime, largePrime);
        }

        int hash = 0;
        for (int i = 0; i < small.length(); i++) {
            hash = moduleHash(hash, large.charAt(i), smallPrime, largePrime);
        }

        if (hash == targetHash && equals(large, 0, small)) {
            return 0;
        }
        for (int i = 1; i <= large.length() - small.length(); i++) {
            hash = nonNegative(hash - seed * large.charAt(i - 1) % largePrime, largePrime);
            hash = moduleHash(hash, large.charAt(i + small.length() - 1), smallPrime, largePrime);
            if (hash == targetHash && equals(large, i, small)) {
                return i;
            }
        }
        return -1;
    }

    private int moduleHash(int hash, int addition, int smallprime, int largePrime){
        return (hash * smallprime % largePrime + addition) % largePrime;
    }  //

    private  int nonNegative(int hash, int largePrime) {
        if (hash < 0) {
            hash = hash + largePrime;
        }
        return hash;
    }

    public static void main(String[] args) {
        IsSubstring is = new IsSubstring();
        int result = is.isSubstring2("aabcd", "bcd");
        System.out.println(result);
        System.out.println((((98 * 31 % 101 + 99) % 101) * 31 % 101 + 100) % 101);
        System.out.println((98 * 31 * 31  + 99 * 31  + 100 ) % 101);
        System.out.println(31 * 31 % 101);
    }

}