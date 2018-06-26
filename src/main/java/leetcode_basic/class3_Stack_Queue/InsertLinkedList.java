package leetcode_basic.class3_Stack_Queue;


import leetcode_basic.class0.ListNode;

/**
 * Created by Dai on 2016/11/28.
 * L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
 */

public class InsertLinkedList {
    public ListNode insert (ListNode head, int value) {
        ListNode input = new ListNode(value);
        if (head == null || head.value >= value)
        {
            input.next = head;
            return input;
        }
        ListNode current = head;
        while (current.next != null) {
            // 到了那里，继续操作，不好。因为需要使用.next
            // 而且要加最后一步判断
            if (value <= current.next.value) {
                input.next = current.next;
                current.next = input;
                return head;
            }
            current = current.next;
        }
        if (value > current.value) {
            current.next = input;
            input.next  = null;
        }
        return head;
    }
    public  ListNode insert2 (ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null || value <= head.value) {
            // 先走到那儿，停下来，再操作
            newNode.next = head;
            return newNode;
        }
        ListNode pre = head;
        while (pre.next != null && pre.next.value < value) {
            // 能走到最后一个，但不执行最后一个
            pre = pre.next;
        }
        newNode.next = pre.next;
        pre.next = newNode;
        return head;
    }

    public static void main (String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(6);
        a1.next = a2;
        a2.next = a3;
        InsertLinkedList il = new InsertLinkedList();
        ListNode result = il.insert(a1,4);
        while (result != null) {
            // 不是result.next
            System.out.println(result.value);
            result = result.next;
        }
    }
}
