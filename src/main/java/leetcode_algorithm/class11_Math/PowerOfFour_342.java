package leetcode_algorithm.class11_Math;

/**
 342. Power of Four
 The basic idea is from power of 2, We can use "n&(n-1) == 0" to determine if n is power of 2. For power of 4, the additional restriction is that in binary form, the only "1" should always located at the odd position. For example, 4^0 = 1, 4^1 = 100, 4^2 = 10000. So we can use "num & 0x55555555==num" to check if "1" is located at the odd position.
 */
public class PowerOfFour_342 {
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
    }
}
