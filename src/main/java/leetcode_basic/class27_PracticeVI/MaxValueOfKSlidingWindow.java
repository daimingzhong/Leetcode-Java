package leetcode_basic.class27_PracticeVI;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxValueOfKSlidingWindow {
    public List<Integer> maxWindow (int[] array, int k) {
        List<Integer> max = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                max.add(array[deque.peekFirst()]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxValueOfKSlidingWindow maxValueOfKSlidingWindow = new MaxValueOfKSlidingWindow();
        List<Integer> res = maxValueOfKSlidingWindow.maxWindow(new int[]{1,2,3,2,1,0}, 3);
        System.out.println(res.toString());
    }
}
