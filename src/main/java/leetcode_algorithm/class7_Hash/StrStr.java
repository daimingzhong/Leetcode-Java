package leetcode_algorithm.class7_Hash;

/**
 28. Implement strStr
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class StrStr {
    public static int strStr(String haystack, String needle) {
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        if (h.length < n.length) {
            return -1;
        }
        if(n.length == 0) {
            return 0;
        }
        for (int i = 0; i <= h.length - n.length; i++) {
            for(int j = 0; j < n.length; j++) {
                if(h[i+j] != n[j]) {
                    break;
                } else if(j == n.length - 1 ) {
                    return i;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }
}
