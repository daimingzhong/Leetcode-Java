package leetcode_basic.class5_BFS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
 * <p>
 * <p>
 * // 如果size < 就先加。不然比较
 * if (i < k) {
 * maxHeap.offer(array[i]);
 * }
 * else if (array[i] < maxHeap.peek()) { // offer smaller
 * maxHeap.poll();
 * maxHeap.offer(array[i]);
 * }
 * <p>
 * maxHeap.offer(array[i]);  // 先加，如果加到size 超出，就减
 * if (maxHeap.size() > k) {
 * maxHeap.poll();
 * }
 */

public class KSmallest {
    public int[] kSmallest(int[] array, int k) {
        if (array == null || array.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((one, two) -> (two - one));
        for (int i = 0; i < array.length; i++) {
            maxHeap.offer(array[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }


    public int[] kSmallest2(int[] array, int k) {
        if (array == null || array.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer one, Integer two) {
                if (one.equals(two)) {
                    return 0;
                } else {
                    return one > two ? -1 : 1; // return (two - one) ; 这样不好，可能会溢出
                }
            }
        });
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] a = null;
        int[] a = new int[]{1, 2, 4, 7};
        KSmallest ks = new KSmallest();
        System.out.println(Arrays.toString(ks.kSmallest(a, 2)));
    }
}
