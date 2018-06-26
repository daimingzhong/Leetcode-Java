package leetcode_algorithm.class11_Math;

/*

400. Nth Digit

Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.


  0      1    2 ..    10  11  ...     100, 101, 102,
  i =   0, 1, 2, 3, 4....
  count = 0,1,2,3.....

                1 2 3

                100
                 10
                  1
a problem: how to output 1, 2, 3.


 */


public class NthDigit_400 {
    public int findNthDigit(int n) {
        int res = 0;
        int count = 0;
        for(int i = 1; i <= n; i++) {
            String ii = String.valueOf(i);
            for(int j = 0; j < ii.length(); j++) {
                int tmp = ii.charAt(j)- '0';// minus 'a'
                count++;
                if (count == n) {
                    return tmp;
                }
            }
        }
        return 0;
    }

    public int findNthDigit2(int n) {
        int len = 1;
        long count = 9;
        int start = 1;
        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }

    public static void main(String[] args) {
        NthDigit_400 nd = new NthDigit_400();
        System.out.println(nd.findNthDigit(12));
    }
}