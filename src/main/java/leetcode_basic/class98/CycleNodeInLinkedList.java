package leetcode_basic.class98;


import leetcode_basic.class0.ListNode;

/**
 * Created by Dai on 2017/1/1.
 * http://stackoverflow.com/questions/2936213/explain-how-finding-cycle-start-node-in-cycle-linked-list-work
 * 一定是快的多走了一圈。
 **/

public class CycleNodeInLinkedList {
    public ListNode cycleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return find(head, slow);
            }
        }
        return null;
    }

    private ListNode find(ListNode first, ListNode second) {
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}