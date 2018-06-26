package leetcode_basic.class98;

/**
 * Created by Dai on 2017/1/2.
 There are in total n steps to Climb until you can reach the top. You can Climb 1 or 2 steps a time. Determine the number of ways you can do that.
 Example:
 Input: n = 4, Return 5.

 */
public class ClimbingStairs {
    public int stairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}