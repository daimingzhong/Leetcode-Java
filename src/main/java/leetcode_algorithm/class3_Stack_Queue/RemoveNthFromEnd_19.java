package leetcode_algorithm.class3_Stack_Queue;

import leetcode_algorithm.class0.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            slow = slow.next;
        }
        if (slow == null) { // for the case, it delete the first element.
            return head.next;
        }
        while (slow.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = fast.next.next;
        return head;
    }
}
