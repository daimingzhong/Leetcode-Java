package leetcode_basic.class3_Stack_Queue;

import leetcode_basic.class0.ListNode;

/**
 * https://discuss.leetcode.com/topic/2975/o-n-solution-by-using-two-pointers-without-change-anything/2
 * Created by Dai on 2016/11/28.
 * LeetCode 142
 */
public class HasCycleII {
    public ListNode hasCycle (ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
    public static void main (String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        a3.next = a1;
        HasCycleII mn = new HasCycleII();
        ListNode result = mn.hasCycle(null);
        System.out.print(result.value);
    }
}
