package leetcode_basic.class8_String;

import java.util.ArrayList;

/**
 * Created by Dai on 2016/12/7.
 * Words are separated by single space
 * There are no heading or tailing white spaces
 * "I love Google” → “Google love I”
 */
public class ReverseWordsInSentence {
    public String reverseWords(String input) {
        char[] array = input.toCharArray(); // 变量名用array就好。用字符串数组的好处是，方程的返回值。
        reverse(array, 0, array.length - 1);
        ArrayList<Integer> blank = new ArrayList<>();
        blank.add(-1);
        for (int i = 0; i < array.length; i++) {
            if(array[i] == ' ') { // 空格是char
                blank.add(i);
            }
        }
        blank.add(array.length); // 尾巴计算错了
        for (int i = 0; i < blank.size() - 1;i++) {
            int start = blank.get(i) + 1;// 这方法太复杂了
            int end = blank.get(i+1);
            reverse(array, start, end - 1);
        }
        //return array.toString();// array.toString，返回的是哈希值
        return new String(array);
    }

    private void reverse(char[] input, int start, int end) {
        while (start < end) {
            char tmp = input[end];
            input[end] = input[start];
            input[start] = tmp;
            start++;
            end--;
        }
    }

    public static void main (String[] args) {
        ReverseWordsInSentence rw = new ReverseWordsInSentence();
        String input = "a b c";
        System.out.print(rw.reverseWords(input));
    }
}
