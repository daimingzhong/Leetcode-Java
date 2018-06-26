package leetcode_algorithm.class8_String;

/*

345. Reverse Vowels of a String

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode_algorithm", return "leotcede".

Note:
The vowels does not include the letter "y".

        0   1   2   3
        a   b   c   e

        0           1

return  e           a

Arraylist        0           3


            b   c
fast:
slow: vowels

use fast again, when we meet vowels, insert one character in new vowel array.

        a e i   length == 3    3/2 = 1
time: O(n)
space: O(n)
        
test case: 
null
""
"b"
"ae"
"abe"        
0 1 2
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReverseVowelsOfAString_345 {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        Set<Character> hashSet = new HashSet<>();
        hashSet.add('a'); hashSet.add('e');  hashSet.add('i');  hashSet.add('o');  hashSet.add('u');
        hashSet.add('A'); hashSet.add('E');  hashSet.add('I');  hashSet.add('O');  hashSet.add('U');
        List<Integer> index = new ArrayList<>();
        char[] ss = s.toCharArray();
        for(int i = 0; i < ss.length; i++) {
            if(hashSet.contains(ss[i])) {
                index.add(i);
            }
        }
        for(int i = 0; i < index.size()/2; i++) {
                swap(ss, index.get(i), index.get(index.size() - 1 - i));// be careful!!
        }
        return new String(ss);
        
    }
    
    private void swap(char[] input, int i, int j) {  // a e i   0  length == 3
        char tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    public String reverseVowels2(String s) {
        if(s == null || s.length()==0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            while(start<end && !vowels.contains(chars[start]+"")){
                start++;
            }
            while(start<end && !vowels.contains(chars[end]+"")){
                end--;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString_345 rs = new ReverseVowelsOfAString_345();
        System.out.println(rs.reverseVowels("abcdeio"));
    }
}