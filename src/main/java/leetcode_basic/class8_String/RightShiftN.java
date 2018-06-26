package leetcode_basic.class8_String;

/**
 * Created by Dai on 2016/12/8.
 * Right shift a given string by n characters.
 * abcdefg 3 输出 efgabcd
 */
public class RightShiftN {
    public String rightShift(String input, int n) {
        // 另一种简单方法是，三翻转，先整体，再两个局部。
        StringBuilder result = new StringBuilder();
        if (input.length() == 0) {
            return input;
        }
        n = input.length() - n%input.length();
        for (int i = n % input.length(); i < input.length(); i++) {
            result.append(input.charAt(i));
        }
        for (int i = 0; i < n%input.length(); i++) {
            result.append(input.charAt(i));
        }
        return result.toString();
    }
    public static void main(String[] args) {
        RightShiftN rs = new RightShiftN();
        System.out.print(rs.rightShift("abcdefg", 0));
    }
}
