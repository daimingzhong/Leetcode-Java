package leetcode_basic.class3_Stack_Queue;


import leetcode_basic.class0.ListNode;

/**
 * Created by Dai on 2017/1/12.
 * L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
 左半边<，右半边>=
 */
public class PartitionLinkedList {
        public ListNode partition(ListNode head, int target) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode small = new ListNode(0);
            ListNode big = new ListNode(0);
            ListNode curSmall = small;
            ListNode curBig = big;
            small.next = head;
            while (head != null) {
                if (head.value < target) {
                    curSmall.next = head;
                    curSmall = curSmall.next;
                } else {
                    curBig.next = head;
                    curBig = curBig.next; // 为什么会有这一步？为什么dummy small就没有这个问题？
                }
                head = head.next;
            }
            curSmall.next = big.next;
            curBig.next = null;
            return small.next;
        }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(7);
        ListNode a3 = new ListNode(2);
        //class0.ListNode a4 = new class0.ListNode(4);
        a1.next = a2;
        a2.next = a3;
        //a3.next = a4;
        PartitionLinkedList rl = new PartitionLinkedList();
        ListNode result = rl.partition(a1, 3);
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }
}
