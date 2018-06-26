package leetcode_basic.class1_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
时间复杂度 O(n)

O(n) + O(n/2) + O(n/4) + ...
找第k个值，如果比pivot小的个数多余k，就只在左半边找了。

 */

public class QuickSelect {
    public int findKthSmallest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    private int genRand(int start, int end) {
        /*
        nextInt生成 0 - end 之间的随机数。不包含end
        e.x start = 0, end = 99. next
        math.random() 返回 [0, 1)
         */
        Random rand = new Random();

        return (int)(Math.random() * 100);
//        return rand.nextInt(end - start + 1) + start;
//        return (int)(Math.random() * (end - start)) + start
    }

    private int quickSelect2(int[] nums, int k, int start, int end) {

        //Choose a pivot randomly
        int index = genRand(start, end);
        int pivot = nums[index];
        swap(nums, index, end);

        int left = start, right = end;

        while(left < right) {
            if (nums[left++] >= pivot) {
                swap(nums, --left, --right);
            }
        }
        //left is now pointing to the first number that is greater than or equal to the pivot
        swap(nums, left, end);

        //m is the number of numbers that is smaller than pivot
        int m = left - start;

        if (m == k - 1) { //in order to find the kth smallest number, there must be k - 1 number smaller than it
            return pivot;
        }
        else if (m > k - 1) { //target is in the left subarray
            return quickSelect2(nums, k, start, left - 1);
        }
        else {
            //target is in the right subarray, but need to update k
            //Since we have discarded m numbers smaller than it which is in the right subarray
            return quickSelect2(nums, k - m, left, end);
        }
    }

    public int quickSelect(int[] input, int k, int start, int end) {
        int left = start; // 操作之后，start不能被改变。
        int right = end - 1;
        while (left <= right) {
            if (input[left] <= input[end])  {
                left++;
            }
            else if (input[right] > input[end] ) {
                right--;
            }
            else{
                swap(input, left, right);
                left++; right--; // why?
            }
        }
        swap(input, left, end); // left的位置 就是 第最后一个数 应该排第几。
        if (left - start == k - 1) {
            return input[left];
        }
        else if (left - start > k - 1) {
            return quickSelect(input, k, start, left - 1);
        } else {
            return quickSelect(input, k - (left - start), left, end);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSelect quickSelect = new QuickSelect();
        int[] input = new int[]{1, 2, 2 , 2 , 2, 3, 4, 5};
        int res = quickSelect.quickSelect(input, 4, 0, input.length - 1);
        System.out.println(res);
        quickSelect.getClass();
        List<Integer> tmp = new ArrayList<>();
        Collections.reverse(tmp);
//        QuickSelect a = new QuickSelect.class;
    }
}
