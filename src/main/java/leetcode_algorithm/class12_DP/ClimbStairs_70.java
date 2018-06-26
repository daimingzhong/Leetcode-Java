package leetcode_algorithm.class12_DP;

/**
 70. Climbing Stairs

 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either Climb 1 or 2 steps. In how many distinct ways can you Climb to the top?

 Note: Given n will be a positive integer.

 1  2   3   4   5   6
 2

 */
public class ClimbStairs_70 {
    public int climbStairs(int n) {
        int[] result = new int[n+1];
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i<=n; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }

    public static void main(String[] args) {
        ClimbStairs_70 clibStairs = new ClimbStairs_70();
        int result = clibStairs.climbStairs(4);
        System.out.println(result);
//        char
    }
}
