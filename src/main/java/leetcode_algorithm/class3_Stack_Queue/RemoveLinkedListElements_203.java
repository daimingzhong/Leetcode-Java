package leetcode_algorithm.class3_Stack_Queue;


import leetcode_algorithm.class0.ListNode;

/**
 203. Remove Linked List Elements

 Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5

 这个题，不是dummy能做的。
 dummy可以删掉头一个点，但是不能连续删掉n个点。
 如果强行要用dummy做，要用两个。

 */
public class RemoveLinkedListElements_203 {
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        while(head != null && head.val == val) {
                head = head.next;
        }
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while(cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode result = removeElements(n1, 1);
        System.out.println(result.val);
    }
}