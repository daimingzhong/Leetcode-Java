package leetcode_algorithm.class11_Math;

/*
169. Majority Element

Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.


1 1 2 1 1 3

result: 1
cur: 1 1 -> 1

stack -> linkedlist
 */

import java.util.Deque;
import java.util.LinkedList;

public class MajorityElement_169 {
    public static int majorityElement(int[] nums) {
        Deque<Integer> linkedList = new LinkedList<>();
        if(nums.length == 1) {
            return nums[0];
        }
        for(int i = 0; i<nums.length; i++) {
            if(linkedList.size() == 0) {
                linkedList.addLast(nums[i]);
            } else if(nums[i] == linkedList.getLast()) {
                    linkedList.addLast(nums[i]);
            } else {
                linkedList.removeLast();
            }
        }
        return linkedList.getLast();
    }

    public int majorityElement2(int[] num) {
        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,3,4}));
    }
}
