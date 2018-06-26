package leetcode_basic.class16_Probability;

/**
 * on offer, means 在售
 * offer means 出价
 * Created by Dai on 2016/11/11.
 * 1  2  3        \\  4   5   6    \\ 7
 * maxHeap            minHeap
 * The aim is to keep the number of max and min as the same. or max = min+1
 * 1. if maxHeap is empty, offer maxHeap
 * 2. if left == right, and if the new input is smaller than maxHeap.peak(), offer maxHeap
 * 3. else, offer minHeap, poll out peak element of minHeap
 * 4. if left == right + 1 , and if the new input is smaller than minHeap.peak(), offer minHeap poll minHeap to maxHeap
 * 取名maxHeap minHeap其实不太好，leftHeap, rightHeap比较好？ 这样操作移位的时候不会出错
 */
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianNumber {
    private PriorityQueue<Integer> maxHeap;// 为什么要写在fields里
    private PriorityQueue<Integer> minHeap;
    public MedianNumber () {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
        // java里默认minHeap，跟书上相反。。。。
    }

    public void read (int value) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(value);
        } else if (maxHeap.size() == minHeap.size()) {
            // 不加else，第一个数会执行两次，或者直接把base case和这个用||合并
            if (value <= maxHeap.peek()) {
                maxHeap.offer(value);
            } else {
                minHeap.offer(value);
                maxHeap.offer(minHeap.poll());
            }
        } else { // 区别在于要不要换数
            if (value <= maxHeap.peek()) {
                maxHeap.offer(value);
                minHeap.offer(maxHeap.peek());
            } else {
                minHeap.offer(value);
            }
        }
    }

    public Double median() {
        int size = (maxHeap.size() + minHeap.size())/2;
        if (maxHeap.size()== 0) { //这里不能写size == 0, 一个数的情况会错
            return null; // null不属于任何一个类，可能跟这个有关，可以返回作double
        }
        if (maxHeap.size() == minHeap.size()){
            return (double) (maxHeap.peek()+minHeap.peek())/2;
        }
        else {
            return (double)maxHeap.peek();
        }
    }

    public  static void main(String[] args) {
        MedianNumber md = new MedianNumber();
        int[] array = {1,2,3};
        for (int i = 0; i<= array.length-1; i++){
            md.read(array[i]);
        }
        System.out.print(md.median());

    }

}
