package leetcode_algorithm.class11_Math;

/*
TODO: 没做
https://discuss.leetcode.com/topic/66771/what-if-we-are-not-smart-enough-to-come-up-with-decrease-1-here-is-how-we-do-it/2
https://discuss.leetcode.com/topic/66575/thinking-process-of-solving-problems-use-java-37ms/2

453. Minimum Moves to Equal Array Elements

Given a non-empty integer array of size n,
find the minimum number of moves required to make all array elements equal,
where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

 */

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements_453 {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int step = 0;
        int finalNum = nums[0];

        for (int i = 1; i < n; i++) {
            int tmp = finalNum;
            finalNum = nums[i] + step;
            if (finalNum == tmp) continue;   //attention!!
            step = finalNum - tmp + step;
        }

        return step;
    }
}