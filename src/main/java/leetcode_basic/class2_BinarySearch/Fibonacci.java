package leetcode_basic.class2_BinarySearch;

// 3rd fibonacci number is 2
// 6th fibonacci number is 8
public class Fibonacci {
    public long fibonacci(int K) {
        if (K <= 0) return 0;
        if (K == 1) return 1;
        long[] result = new long[K+1];
        //因为k其实是第K+1个解
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= K; i++)  {
            result[i] = result[i-1]+result[i-2];
        }
        return result[K];
    }
    public static void main(String[] args) {
        int num = 49;
        Fibonacci solution = new Fibonacci();
        long a = solution.fibonacci(num);
        System.out.println(a);
    }
}

