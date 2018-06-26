package leetcode_algorithm.class6_DFS;

/*

401. Binary Watch

A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

for the first time, n possibilies. for the second n - 1 possibilities. so for+dfs is n!

        32                   16          8        4       2          1
     16   8   ....

    return

    in total, there are two layers. if(layer == 2) {}
    for the first layer, the selections are all from 32 - 1. for the second layer, from 16 - 1.
    for(int i = 0; i < nums.length; i++) {} // change to for(int i = pos;) we pass position down.

 */


import java.util.ArrayList;
import java.util.List;

public class BinaryWatch_401 {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[]{8, 4, 2, 1}, nums2 = new int[]{32, 16, 8, 4, 2, 1};
        for(int i = 0; i <= num; i++) {
            List<Integer> list1 = generateDigit(nums1, i);
            List<Integer> list2 = generateDigit(nums2, num - i);
            for(int num1: list1) {
                if(num1 >= 12) continue;
                for(int num2: list2) {
                    if(num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }

    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }

    private void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if(count == 0) {
            res.add(sum);
            return;
        }
        // TODO: 为什么这里这么写？？往里面加1，加过0吗。没有加过，0是通过2层结束，砍掉来实现的。因为不是三层，所以不需要删。
        for(int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }

    public static void main(String[] args) {
        BinaryWatch_401 pw = new BinaryWatch_401();
        List<String> result = pw.readBinaryWatch(2);
        for(String i : result){
            System.out.println(i);
        }
    }
}
