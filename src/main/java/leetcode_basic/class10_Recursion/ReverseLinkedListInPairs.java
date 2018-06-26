package leetcode_basic.class10_Recursion;

import leetcode_basic.class0.ListNode;

/**
 * Created by Dai on 2016/12/8.
 *  L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
 *  L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null
 */
public class ReverseLinkedListInPairs {
    // recursion 和 dfs 有点像
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = reverseInPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ReverseLinkedListInPairs rev = new ReverseLinkedListInPairs();
        StringBuilder sb = new StringBuilder();
        ListNode ls = rev.reverseInPairs(n1);
        while(ls != null) {
            sb.append(ls.value);
            ls = ls.next;
        }
        System.out.print(sb);

    }
}
