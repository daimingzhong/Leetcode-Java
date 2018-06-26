package leetcode_basic.class3_Stack_Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Dai on 2017/1/14.
 Enhance the stack implementation to support min() operation.
 min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.

 pop() - remove and return the top element, if the stack is empty, return -1
 push(int element) - push the element to top
 top() - return the top element without remove it, if the stack is empty, return -1
 min() - return the current min value in the stack.
 */

public class StackWithMin {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    public StackWithMin() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    // 获得并删除头
    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int result = stack.poll(); // poll First 也可以
        if(minStack.peekFirst() == result) {
            minStack.poll();
        }
        return result;
    }

    public void push(int element) {
        stack.push(element); // offerFirst 也可以
        if(minStack.isEmpty() || element <= minStack.peekFirst()){
            minStack.push(element);
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}

