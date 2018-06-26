package leetcode_basic.class3_Stack_Queue;

import leetcode_basic.class0.ListNode;

/**
 * Created by Dai on 2016/11/28.
 * Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null
 * to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
 * L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
 */

public class ReorderLinkedList {
    public ListNode reorder (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode second = mid.next;
        mid.next = null;
        second = reverse2(second);
        ListNode start = combine(head, second);
        return start;
    }

    public ListNode findMid (ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode listNode){
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = listNode;
        while (dummy.next != null) {
            ListNode tmp = dummy.next.next;
            dummy.next.next = listNode;
            dummy = dummy.next;
            dummy.next = tmp;
        }
        dummy = null;
        return listNode;
    }

    public ListNode reverse2(ListNode listNode) {
        if (listNode == null || listNode.next == null){
            return listNode;
        }
        ListNode pre = null;
        while (listNode != null) {
            ListNode next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;
            //只管当前节点，是用当前节点指向前面节点。这种方法不需要dummy node
            // 先保存下一个，再指向前一个。前一个后移。当前的后移
        }
        return pre;
        // 注意返回值不是ListNode
    }

    public  ListNode combine (ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        // 这里是要新建一个头。先构造dummy，再构造当前，当前处理完了，返回dummy.next
        while (one != null && two != null) {
            current.next = one;
            one = one.next;
            // 这句话不能发到下一句后面
            // current已经指向了one指向的东西，如果current变了，one指向的东西也变了。
            // 所以要指定one的下一步之后，其实这时候current的下一步也变了，是one里的。
            // 他俩都指向465这块内存里的东西
            current.next.next = two;
            two = two.next;
            current = current.next.next;
        }
        if (one != null) {
            current.next = one;
        }
        else{
            current.next = two;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ReorderLinkedList rl = new ReorderLinkedList();
        ListNode result  = rl.reorder(a1);
        while (result!= null){
            System.out.println(result.value);
            result = result.next;
        }
    }
}
