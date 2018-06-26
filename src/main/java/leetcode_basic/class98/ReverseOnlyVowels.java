package leetcode_basic.class98;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dai on 2017/1/1.
 * "abbegi" --> "ibbega"
 * 只换期中元音的顺序，辅音不变
 * 元音变两遍。
 */
public class ReverseOnlyVowels {
    public String reverse(String input) {
        Set<Character> set = new HashSet<>();
        char[] array = input.toCharArray();
        String vowels = "aeiou";
        for (int i = 0; i < vowels.length(); i++) {
            set.add(vowels.charAt(i));
        }
        int j = input.length() - 1;
        for (int i = 0; i < input.length()/2 && j >= input.length()/2; ) {
            if (!set.contains(input.charAt(i))) {
                ++i;
            }
            if (!set.contains(input.charAt(j))) {
                --j;
            }
            if (set.contains(input.charAt(i)) && set.contains(input.charAt(j))) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        return new String(array);
    }
    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        ReverseOnlyVowels ro = new ReverseOnlyVowels();
        String result = ro.reverse("oxygen");
        System.out.println(result);
    }
}