package leetcode_algorithm.class11_Math;

/*

190. Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

//TODO: 什么是unsigned
 */

public class ReverseBits_190 {

    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i<32; i++) {
            result += n & 1;
            n>>>=1;
            if(i < 31) {
                result <<= 1;
            }
        }
        return result;
    }

    public static int reverseBits2(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            sb.append(n&1);
            n >>= 1;
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(reverseBits2(43261596));
    }
}
