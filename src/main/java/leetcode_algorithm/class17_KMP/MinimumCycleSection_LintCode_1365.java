package leetcode_algorithm.class17_KMP;

/*

https://www.lintcode.com/en/problem/minimum-cycle-section/
Given array = [1,2,1,2,1], return 2.

Explanation:
The minimum cycle section is [1,2]，and the length is 2, although the last 2 is not given, we still consider the cycle section is [1,2].

solution:
https://www.jiuzhang.com/solution/minimum-cycle-section/

这里的操作和kmp算法求next一样，循环节就是 (i - 1) - ( next[i] - 1 ) = i - next[i]

 */

public class MinimumCycleSection_LintCode_1365 {
    public static int minimumCycleSection(int[] array) {

        int [] next = new int[array.length + 1];
        int i = 0;
        int j = -1;
        next[0] = -1;
        while(i < array.length) {
            if(j == -1 || array[i] == array[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return i - next[i];
    }

    public static void main(String[] args) {
        int[] input = {1,2,1,2,1};
        int[] input2 = {3,1,2,3,1,2,3}; // 实际上可以当成 3 1 2
        // 这个题要从基本的例子做几遍就能理解了。
        int res = MinimumCycleSection_LintCode_1365.minimumCycleSection(input2);
        System.out.println(res);
    }
}
