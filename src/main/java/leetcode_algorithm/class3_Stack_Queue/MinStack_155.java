package leetcode_algorithm.class3_Stack_Queue;

/*
155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();


1. use two stack.

        5 2 3 4 2 1     stack

        5 2     2 1     min

pop     if min.peek() == stack.pop() pop from min
push    if min.peek() >= stack, push to min

https://discuss.leetcode.com/topic/41486/simple-java-solution-12-line/2


 */

import java.util.Stack;

public class MinStack_155 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public MinStack_155() {

    }

    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        if(stack.pop().equals(min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack_155 ms = new MinStack_155();
        ms.push(1);
        ms.push(2);
        ms.getMin();
        ms.pop();
        ms.getMin();
        ms.pop();
    }

}
