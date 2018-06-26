package leetcode_algorithm.class8_String;

/*

            0    1     2    3   4
            h    e     l    l   o

            O                   H

 */


public class ReverseString_344 {
    public String reverseString(String s) {
        char[] ss =  s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = ss.length - 1; i >= 0; i--) {
            // < s.length.表示到达s.length - 1 结束。 i>=0, 表示=0的时候，结束。因为回来的时候，i是-1。
            sb.append(ss[i]);
        }
        return sb.toString();
    }

    public String reverseString2(String s) {  // may cause stack over flow problem
        char[] ss = s.toCharArray();
        helper(ss, 0, ss.length - 1);
        return new String(ss);
    }

    private void helper(char[] s, int start, int end) {
        if(start >= end) {
            return;
        }
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;
        helper(s, start + 1, end - 1);
    }


        public static void main(String[] args) {
        ReverseString_344 rs = new ReverseString_344();
        System.out.println(rs.reverseString2("hello"));
    }
}