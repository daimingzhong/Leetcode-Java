package leetcode_algorithm.class11_Math;

/*

405. Convert a Number to Hexadecimal

Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

Note:

All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library which converts/formats the number to hex directly.
Example 1:

Input:
26

Output:
"1a"
Example 2:

Input:
-1

Output:
"ffffffff"


  1 1 1 1  | 1 1 1 0
  use four digits to a hex. & 15 , >>> 4.
  We deal the least important 4 digits first. so, we have to append to the start position every time.
  we can use .reverse() or sb.append(0, "cur")

>>1 算数，相当于/2
>>>1 全都右移

 */

public class ConvertANumberToHexadecimal_405 {
    public static String toHex(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder result = new StringBuilder();
        if(num == 0) {
            return "0";
        }
        while(num != 0) {
//            result.append(map[num&15]);
            result.insert(0, map[num&15]);
            num >>>= 4;
        }
        return result.toString();
//        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(26));
    }
}
