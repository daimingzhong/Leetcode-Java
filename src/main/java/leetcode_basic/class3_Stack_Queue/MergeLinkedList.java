package leetcode_basic.class3_Stack_Queue;

import leetcode_basic.class0.ListNode;

/**
 * Created by Dai on 2016/11/28.
 * L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null
 * merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
 */

public class MergeLinkedList {
    public ListNode merge (ListNode one, ListNode two) {
        ListNode current = new ListNode(0);
        ListNode dummy = current;
        while (one != null && two != null) {
            if (one.value <= two.value) {
                current.next = one;
                one = one.next;
            }
            else {
                current.next = two;
                two = two.next;
            }
            current = current.next;
        }
        if (one != null) {
            current.next = one;
        }
        else {
            current.next = two;
        }
        return dummy.next;
    }
}
