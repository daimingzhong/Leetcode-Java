package leetcode_algorithm.class0;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode pre;

    public ListNode(int x) {
        val = x;
    }

    // return 1->2-> .. -> n
    public ListNode newListNode(int n) {
        ListNode dummy = new ListNode(0);
        for (int i = 0; i < n; i++) {
            dummy.next = new ListNode(i);
        }
        return dummy;
    }

    public ListNode newDoublyLinkedListNode(int n) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < n; i++) {
            ListNode tmp = new ListNode(i);
            cur.next = tmp;
            tmp.pre = cur;
            cur = cur.next;
        }
        return dummy;
    }
}