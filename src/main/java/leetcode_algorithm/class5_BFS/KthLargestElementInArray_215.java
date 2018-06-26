package leetcode_algorithm.class5_BFS;

import java.util.PriorityQueue;

/*

215. Kth Largest Element in an Array

Find the kth largest element in an unsorted array.
Note that it is the kth largest element in the sorted order,
not the kth distinct element.
For example, Given [3,2,1,5,6,4] and k = 2, return 5.

Note:
You may assume k is always valid, 1 ? k ? array's length.

by default, java's heap is min-heap
PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

 */

public class KthLargestElementInArray_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                pq.add(nums[i]);
            } else {
                if (nums[i] > pq.peek()) {
                    pq.add(nums[i]);
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}

