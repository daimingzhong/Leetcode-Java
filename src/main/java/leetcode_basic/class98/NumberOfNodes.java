package leetcode_basic.class98;

import leetcode_basic.class0.ListNode;

/**
 * Created by Dai on 2017/1/1.
 *
 * L = null, return 0
 L = 1 -> null, return 1
 L = 1 -> 2 -> null, return 2
 */
public class NumberOfNodes {
    public int numberOfNodes(ListNode head) {
        if (head == null) {
            return 0;
        }
        int result = 0;
        while (head != null) {
            head = head.next;
            result++;
        }
        return result;
    }
}