package leetcode_algorithm.class11_Math;

/*
191. Number of 1 Bits
Write a function that takes an unsigned integer and returns the number of ’1' bits it has
(also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
so the function should return 3.

 */
public class NumberOfOneBits_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        return ones;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        for(int i=0; i<32; i++){
            count += (n >> i & 1) == 1 ? 1: 0;
        }
        return count;
    }
}