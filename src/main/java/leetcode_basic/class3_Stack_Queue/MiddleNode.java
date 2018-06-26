package leetcode_basic.class3_Stack_Queue;/*
L = 1 -> 2 -> 3 -> null, return 2
L = 1 -> 2 -> 3 -> 4 -> null, return 2
 */


import leetcode_basic.class0.ListNode;

public class MiddleNode {
    public ListNode middleNode (ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            // 可以走两步，就是next.next。
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode middleNode2 (ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = head;
        ListNode result = head;
        int length = 0;
        while (dummy.next != null) {
            length++;
            dummy = dummy.next;
        }
        while (length/2 > 0) {
            // 注意while的写法。这里>
            result = result.next;
            length -= 2;
        }
        return result;
    }
    public static void main (String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        MiddleNode mn = new MiddleNode();
        int result = mn.middleNode2(a1).value;
        System.out.print(result);
    }
}
