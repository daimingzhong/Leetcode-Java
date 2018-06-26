package leetcode_algorithm.class11_Math;

/*

204. Count Primes

Description:

Count the number of prime numbers less than a non-negative number, n.

todo: 没做
 */


public class CountPrimes_204 {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}
