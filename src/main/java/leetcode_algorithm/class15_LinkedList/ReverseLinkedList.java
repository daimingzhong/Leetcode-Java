package leetcode_algorithm.class15_LinkedList;


import leetcode_algorithm.class0.ListNode;

/**
 * 206. Reverse Linked List
 time : O(n);
 space : O(1);


            1   ->       2           -> 3
    pre    head

 1. head.next 存起来
 2. 给head.next 值
 3. pre / head 都往后挪

 需要两个指针，一个存pre，一个存next。
 pre的是全局变量。因为到了下一个，前一个就丢掉了。
 next是局部变量，每次都能由当前get到。

 反转链表对每一个点需要做两件事：
 1. 把和后面的连结断掉。（需要存后面的）
 2. 和前面的简历连结。（需要存前面的）

 while(head != null) {
     head.next = pre
     pre = head
     head = temp
 }

 */

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
