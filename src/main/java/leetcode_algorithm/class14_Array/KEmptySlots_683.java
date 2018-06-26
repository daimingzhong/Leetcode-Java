package leetcode_algorithm.class14_Array;

/*
https://leetcode.com/problems/k-empty-slots/description/

There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N flowerIndex.
In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower will open in that day.

For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be in the range from 1 to N.

Also given an integer k, you need to output in which day there exists two flowers in the status of blooming,
and also the number of flowers between them is k and these flowers are not blooming.

If there isn't such day, output -1.
The given array will be in the range [1, 20000].

e.g
[1,3,2]  k = 1
第1天，在位置1开花。
第2天，在位置3开花
第3天，在位置2开花。

输出: 2
在第二天，1，3都开了，并且他们之间未开花的数量是1。

flowers: [1,2,3] k: 1
Output: -1

https://leetcode.com/problems/k-empty-slots/discuss/107931/JavaC++-Simple-O(n)-solution


第二题是那个种花的。这个感觉有些区别。它没问empty slots，问的是k-sized flower cluster。
就是说给你一个k，如果这一排里面有任意一组连续的几朵花长度是k，即满足要求。不过它问的是最后一天满足这个要求的天数。

解法倒是不难，我是按照lc的解法改了改，把天数从后往前遍历的，当做每天有一朵花要收起来，然后把现在的empty slot当做是原版题里面的花，把花当做原版里面empty slots。
这个做法有一个要特别注意的地方：原版里面的empty slots要求两边都有花夹住这一组empty slots，但是这道题里面如果有连续k朵花是从墙开始数的，那么这个是要算成符合要求的。所以你要想办法把这个改动解决掉。[/hide]
 */

import java.util.TreeSet;

public class KEmptySlots_683 {
    public int kEmptySlots(int[] flowers, int k) {
        int[] tmp = new int[flowers.length + 1];  //
        for (int i = 1; i <= flowers.length; i++) {
            tmp[flowers[i - 1]] = 1;
            for (int j = flowers[i - 1] - 1; j >= 1; j--) {  // j is the location of flower
                if (tmp[j] == 1) {
                    if (flowers[i - 1] - j == k + 1) {
                        return i;
                    } else {
                        break;
                    }
                }
            }
            for (int w = flowers[i - 1] + 1; w <= flowers.length; w++) {
                if (tmp[w] == 1) {
                    if (w - flowers[i - 1] == k + 1) {
                        return i;
                    } else {
                        break;
                    }
                }
            }
        }
        return -1;
    }

    // method 2
    public int kEmptySlots2(int[] flowers, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int cur = flowers[i];
            treeSet.add(cur);
            Integer high = treeSet.higher(cur);
            if (high != null && high - cur == k + 1) {
                return i + 1;
            }
            Integer low = treeSet.lower(cur);
            if (low != null && cur - low == k + 1) {
                return i + 1;
            }
        }
        return -1;
    }

    // method 3
    public int kEmptySlots3(int[] flowers, int k) {         // flowers is actually dayIndex
        int[] flowerIndex = new int[flowers.length];

        for (int i = 0; i < flowerIndex.length; i++) {
            flowerIndex[flowers[i] - 1] = i + 1;
        }
        int left = 0;
        int right = k + 1;
        int res = Integer.MAX_VALUE;

        for (int i = 1; right < flowerIndex.length; i++) {
            if (flowerIndex[i] > flowerIndex[left] && flowerIndex[i] > flowerIndex[right]) {   // no need to move left or right
                continue;
            }
            if (i == right) { // not valid and sliding window size is k + 1
                int cur = Math.max(flowerIndex[left],flowerIndex[right]);
                res = Math.min(res, cur);
            }

            left = i;             // cur flower is not valid
            right = i + k + 1;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    public static void main(String[] args) {
        KEmptySlots_683 kEmptySlots_683 = new KEmptySlots_683();
//        int res = kEmptySlots_683.kEmptySlots3(new int[]{1, 3, 2}, 1);
//        System.out.println(res);

        int res = kEmptySlots_683.kEmptySlots3(new int[]{6,5,8,9,7,1,10,2,3,4}, 2);
        System.out.println(res);
    }
}
