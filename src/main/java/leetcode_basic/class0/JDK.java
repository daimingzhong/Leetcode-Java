package leetcode_basic.class0;

import java.util.*;

public class JDK {
    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<>();  // stack 本身不是interface
        Queue<Integer> queue = new ArrayDeque<>();  // LinkedList 也可以
        stack.push(1);
        stack.pop();
        stack.peek();

        queue.offer(1);
        queue.poll();
        queue.peek();
    }
}
