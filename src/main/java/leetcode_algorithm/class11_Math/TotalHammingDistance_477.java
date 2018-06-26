package leetcode_algorithm.class11_Math;

/*

http://www.cnblogs.com/grandyang/p/6208062.html

477. Total Hamming Distance

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2

Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

Note:
Elements of the given array are in the range of 0 to 10^9
Length of the array will not exceed 10^4.


 */

public class TotalHammingDistance_477 {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for(int i = 0; i<nums.length - 1; i++) {
            for(int j = i; j<nums.length; j++) {
                result += ham(nums[i], nums[j]);
            }
        }
        return result;
    }

    private int ham(int a, int b) {
        int result = 0;
        int xor = a^b;
        while(xor != 0) {
            result += xor&1;
            xor >>= 1;
        }
        return result;
    }

    public int totalHammingDistance2(int[] nums) {
        int ans= 0 ;
        int bit = 1;
        for(int i = 0;i<31;i++){
            int zero = 0, one = 0;
            for(int j =  0;j<nums.length;j++){
                if((nums[j]&bit) == 0){
                    zero++;
                } else {
                    one++;
                }
            }
            ans+=zero*one;
            bit<<=1;
        }
        return ans;
    }
}
