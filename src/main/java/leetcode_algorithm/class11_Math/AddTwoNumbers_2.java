package leetcode_algorithm.class11_Math;

/*
2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

这个题，写法很贱。
carry, l1, l2 地位一样。
赋值的时候，是给dummy的next赋值。如果是给dummy赋值也可以，返回的时候，确定返回dummy就可以了。
仔细注意，到底放回dummy还是next。由赋值情况决定。
另外，不要忘了移动。
 */


import leetcode_algorithm.class0.ListNode;

public class AddTwoNumbers_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        ListNode tmp = new ListNode(0);
        int up = 0;
        while(l1 != null && l2 != null) { // 一般不用dummy的，这里不是next
            int sum = l1.val + l2.val + up;
            tmp.val = (sum) > 10? (sum - 10) : sum;
            dummy.next = tmp;
            if(l1.val + l2.val >= 10) {
                up = 1;
            } else {
                up = 0; //don't forget
            }
            l1 = l1.next;// don't forget!!! to move
            l2 = l2.next;
            dummy = dummy.next;
        }
        while(l1 != null) {
            int sum = l1.val + up;
            tmp.val = (sum) > 10? (sum - 10) : sum;
            dummy.next = tmp;
            if(sum >= 10) {
                up = 1;
            } else {
                up = 0; //don't forget
            }
            l1 = l1.next;// don't forget!!! to move
            dummy = dummy.next;
        }
        while(l2 != null) {
            int sum = l2.val + up;
            tmp.val = (sum) > 10? (sum - 10) : sum;
            dummy.next = tmp;
            if(sum >= 10) {
                up = 1;
            } else {
                up = 0; //don't forget
            }
            l2 = l2.next;// don't forget!!! to move
            dummy = dummy.next;
        }
        if (up == 1) {
            dummy.next = new ListNode(0);
        }
        return result; // 这里错了很多次了。
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(8);
        n1.next = n3;
//        n2.next = n4;
        addTwoNumbers(n1, n2);
    }
}