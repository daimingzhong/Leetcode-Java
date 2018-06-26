package leetcode_algorithm.class1_Sorting;

import leetcode_algorithm.class0.ListNode;

/**

 148. Sort List

 Sort a linked list in O(n log n) time using constant space complexity.

 merge sort is based on merge two sorted list.
 value to pass: head of two list.
 value to return: head of merged result / head of merged list.
 */


public class LinkedListMergeSort_148 {
    public static ListNode sortList(ListNode head) {  // for splitting list. and pass to the merge function
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, pre = head;
        while (fast.next != null && fast.next.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;  //

        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummyNode = new ListNode(0); // only construct a new head, so space complexity is O(1)
        ListNode tmp = dummyNode;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tmp.next = left;
                left = left.next;
            } else {
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }
        if (left != null) {
            tmp.next = left;
        }
        if (right != null) {
            tmp.next = right;
        }
        return dummyNode;
    }

    public static void main(String[] args) {
      ListNode a = new ListNode(3);
      ListNode b = new ListNode(2);
      a.next = b;
      b.next = null;
      sortList(a);
      System.out.println(a.next.val);
    }
}
