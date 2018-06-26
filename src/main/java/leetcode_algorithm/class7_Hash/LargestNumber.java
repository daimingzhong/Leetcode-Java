package leetcode_algorithm.class7_Hash;

import java.util.Arrays;
import java.util.Comparator;

/**
 179. Largest Number

 https://leetcode.com/problems/largest-number/discuss/

 Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.

 Credits:
 Special thanks to @ts for adding this problem and creating all test cases.

 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return "";
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };
        String[] num = new String[nums.length];
        for(int i = 0; i<nums.length; i++){
            num[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(num, comp);
        if(num[0].charAt(0) == '0'){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s:num) {
            sb.append(s);
        }
        return sb.toString();
    }
}