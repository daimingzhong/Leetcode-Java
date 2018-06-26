package leetcode_basic.class3_Stack_Queue;


import leetcode_basic.class0.ListNode;

/**
 * Created by Dai on 2016/11/27.
 */
public class HasCycle {
    public boolean hasCycle (ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public static void main (String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        a3.next = a1;
        HasCycle mn = new HasCycle();
        boolean result = mn.hasCycle(a1);
        System.out.print(result);

    }
}
