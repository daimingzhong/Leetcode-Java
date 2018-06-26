package leetcode_algorithm.class3_Stack_Queue;

import java.util.Stack;

/**

 "1 + 1" = 2
 " 2-1 + 2 " = 3
 "(1+(4+5+2)-3)+(6+8)" = 23

 time : O(n)
 space : O(n)

 */

public class BasicCalculator_224 {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += num * sign;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {  // 1 - 2 处理成 1 + (-2)
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BasicCalculator_224 basicCalculator_224 = new BasicCalculator_224();
        int res = basicCalculator_224.calculate("1 + 3 - (2 + 1)");
        System.out.println(res);
    }
}
