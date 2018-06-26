package leetcode_algorithm.class3_Stack_Queue;


import leetcode_algorithm.class0.ListNode;

/**
 * 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 */
public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (slow == null || slow.next == null) {
            return false;
        }
        while (fast.next != null && fast.next.next != null) {
            // 两个fast判断，第二个也是必须的。如果fast正好走到最后一个。fast.next.next是不存在的。
            // 规律，一下引用的变量，以上要定义为非null。
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
