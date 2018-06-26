package leetcode_algorithm.class3_Stack_Queue;


import leetcode_algorithm.class0.ListNode;

/*

61. Rotate List

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */

public class RotateList_61 {

    public ListNode rotateRight2(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        int i;
        for (i = 0; fast.next != null; i++) { //Get the total length
            fast = fast.next;
        }
        for (int j = i - n % i; j > 0; j--) { //Get the i-n%i th node
            slow = slow.next;
        }
        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = helper(head);
        k = length - k % length;
        if (k == length) {
            return head;
        }
        ListNode slow = new ListNode(0), fast = new ListNode(0);
        fast.next = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        ListNode newHead = fast.next; // 因为这里的ListNode全是自己定义的对象。所以和ArrayList不同。
        fast.next = null;
        slow.next = newHead;
        for (int i = 0; i < length - k; i++) {
            slow = slow.next;
        }
        slow.next = head;
        return newHead;
    }

    private int helper(ListNode root) { // head完全可以换个名字，变成root。
        int count = 0;
        while (root != null) {
            root = root.next;
            count++;
        }
        return count;
//        ListNode dummy = root; // 新生成一个，dummy对root是没有影响的。
//        while(dummy != null) {
//            dummy = dummy.next;
//            count++;
//        }
    }


    public static void main(String[] args) {
        ListNode l0 = new ListNode(0);
        l0 = l0.newListNode(6);
        RotateList_61 ro = new RotateList_61();
        ro.rotateRight(l0, 0);
    }
}
