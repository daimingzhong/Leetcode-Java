package leetcode_algorithm.class3_Stack_Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 queue api: fifo
 push()
 pop()
 top()

 问题：
 stack 1: 1 2 3 4
 stack 2: -> 4, 3, 2, 1

 queue: add() remove()

 add() 就是O(1) 因为queue和stack的add方法一样
 remove() 还是O(1) ex: 第一次，把1 2 3 4扔到stack2里，pop第一个是O(2n)（读+写），之后都是O(1)，amotized还是O(1)


 问题：
 implement min() when using stack with time O(1).
 stack1: 2 1 -7 -6         -8 5 4 -10
 stack2: 2 1 -7 -7


 时间O(1)
 空间O(n)

 假设：有很多重复的值，要怎么优化空间。
 stack1: 1 1 1 1 2 2 -1 -1
 stack2:<1, 1> <-1, 7>
 记录数字和位置，只要判断stack1的size()是否>7，就知道是否到了-1的下一步。
 stack2 is in decending order, <value, size of stack1>


 stack: push(), pop(), peak()
 // 如果我需要一个stack，定义的时候，用deque。因为stack就是反着的queue。然后用ArrayDeque或者linkedlist。

 linkedlist作为stack，方法都是first，offerFirst，pollFirst，peekFirst。(return true/false)
                                   addFirst, removeFirst, peekFirst. (return void) 和push pop peek一样。返回值都是void
 之所以是First，是因为stack只用了deque的左半边。所以加要加到first，减也是减first。

 todo: 下面的解答好像不对
 */

public class QueueByTwoStack_232 {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public QueueByTwoStack_232(){
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void push(int value) {
        stack1.offerFirst(value);
        if(stack2.isEmpty() || value <= stack2.peekFirst()) {
            stack2.offerFirst(value);
        }
    }

    public Integer pop() {
        if(stack1.isEmpty()) {
            return null;
        }
        Integer result = stack1.pollFirst();
        if (stack2.peekFirst().equals(result)) {
            stack2.pollFirst();
        }
        return result;
    }

    public Integer top() {
        if(stack1.isEmpty()) {
            return null;
        }
        return stack1.peekFirst();
    }

    public Integer min() {
        if(stack2.isEmpty()){
            return null;
        }
        return stack2.peekFirst();
    }
}
