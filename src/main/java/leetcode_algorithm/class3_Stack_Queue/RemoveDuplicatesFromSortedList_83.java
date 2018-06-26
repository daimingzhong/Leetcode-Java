package leetcode_algorithm.class3_Stack_Queue;

/*

83. Remove Duplicates from Sorted List

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

import leetcode_algorithm.class0.ListNode;

public class RemoveDuplicatesFromSortedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode cur = head;
        while(cur != null) {
            while(cur.next!= null && cur.next.val == cur.val) {
                cur.next = cur.next.next;
            }
                cur = cur.next;
        }
        return head;
    }
}
