package leetcode_basic.class3_Stack_Queue;

import leetcode_basic.class0.ListNode;

/*
 L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
*/

public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverse2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    public static void main(String[] args){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ReverseLinkedList exam = new ReverseLinkedList();
        //a1, a2的存储位置并没有改变，只改变了他们的.next
        ListNode result  = exam.reverse2(a1);
        while (result!= null){
            System.out.println(result.value);
            result = result.next;
        }
    }
}
