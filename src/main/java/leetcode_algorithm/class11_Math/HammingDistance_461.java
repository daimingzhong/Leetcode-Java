package leetcode_algorithm.class11_Math;

/*

461. Hamming Distance

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */

public class HammingDistance_461 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int result = 0;
        while(xor != 0) {
            result += xor & 1;
            xor >>= 1;
        }
        return result;
    }

    public int hammingDistance2(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i=0;i<32;i++) {
            count += (xor >> i) & 1;
        }
        return count;
    }
}