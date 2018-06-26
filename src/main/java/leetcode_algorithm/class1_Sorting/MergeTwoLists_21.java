package leetcode_algorithm.class1_Sorting;


import leetcode_algorithm.class0.ListNode;

/**
 21. Merge Two Sorted Lists
 Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists.
 */

public class MergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode  dummy;
        if(l1.val < l2.val){
            // current layer is sorting current nodes, and returning the head.
            // go to buttom and return in the last.
            dummy = l1;
            dummy.next = mergeTwoLists(l1.next, l2);
        } else {
            dummy = l2;
            dummy.next = mergeTwoLists(l2.next, l1);
        }
        return dummy;
    }
}