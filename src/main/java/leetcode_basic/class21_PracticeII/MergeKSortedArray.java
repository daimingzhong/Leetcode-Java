package leetcode_basic.class21_PracticeII;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge K sorted array into one big sorted array in ascending order.
 * <p>
 * 静态类：只能内部类使用。
 * http://www.cnblogs.com/Alex--Yang/p/3386863.html
 * 静态内部类使用场景一般是当外部类需要使用内部类，而内部类无需外部类资源，
 * 并且内部类可以单独创建的时候会考虑采用静态内部类的设计，
 * <p>
 * java的heap是minheap，也就是按自然数排列。
 * <p>
 * 两种方法
 * 1. divide and conquer
 * <p>
 * 2. maxheap
 */

public class MergeKSortedArray {

    public int[] merge(int[][] arrayOfArrays) {
        // mycomparator 告诉pq，怎么比，比什么。这里比的是value
        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(11, new MyComparator());
        int length = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            int[] array = arrayOfArrays[i];
            length += array.length;
            if (array.length != 0) {
                minHeap.offer(new Entry(i, 0, array[0]));
            }
        }
        int[] result = new int[length];
        int cur = 0;
        while (!minHeap.isEmpty()) {
            Entry tmp = minHeap.poll();
            result[cur++] = tmp.value;
            if (tmp.y + 1 < arrayOfArrays[tmp.x].length) {
                tmp.y++;
                tmp.value = arrayOfArrays[tmp.x][tmp.y];
                minHeap.offer(tmp);
            }
        }
        return result;
    }


    static class MyComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry e1, Entry e2) {
            if (e1.value == e2.value) {
                return 0;
            }
            return e1.value < e2.value ? -1 : 1;
        }
    }

    static class Entry {
        int x;
        int y;
        int value;

        Entry(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MergeKSortedArray mk = new MergeKSortedArray();
        int[] result = mk.merge(new int[][]{{1, 2, 5}, {3, 4, 6}});
        System.out.println(Arrays.toString(result));
    }
}
