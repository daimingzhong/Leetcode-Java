package leetcode_algorithm.class3_Stack_Queue;


import leetcode_algorithm.class0.ListNode;

/**
 24. Swap Nodes in Pairs

 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

public class SwapNodeInPairs_24 {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy  = new ListNode(0);
        ListNode result = dummy;
        dummy.next = head;
        if(head == null || head.next == null) {
            return head;
        }
        ListNode tmp;
        while(dummy.next!= null && dummy.next.next != null) { // 注意这里不是用head
            tmp = dummy.next.next;
            dummy.next.next = dummy.next.next.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
            dummy = dummy.next.next; // don't forget to move head.
        }
        return result.next;
    }
}