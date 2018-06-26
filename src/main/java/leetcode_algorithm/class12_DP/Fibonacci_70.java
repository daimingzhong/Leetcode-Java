package leetcode_algorithm.class12_DP;

/*
https://leetcode.com/problems/climbing-stairs/solution/
 */
public class Fibonacci_70 {
    public int climbStairs(int n) {
        int[] result = new int[n+1];
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        result[1] = 1;
        for (int i = 2; i<=n; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }

    public static void main(String[] args) {
        Fibonacci_70 fibonacci = new Fibonacci_70();
        int result = fibonacci.climbStairs(4);
        System.out.println(result);
    }
}
