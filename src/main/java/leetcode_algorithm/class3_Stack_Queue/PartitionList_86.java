package leetcode_algorithm.class3_Stack_Queue;


import leetcode_algorithm.class0.ListNode;

/**

 86. Partition List

 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.

 自己过case的时候，不要忘了base case。长度为0，长度为1。
 For this list: 5->6->1->2, x=3, at last cur2 points to 6, cur1 points to 2, we must set 6->1 to 6->null, otherwise there will be a cycle.

 */
public class PartitionList_86 {
    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode half = large;
        ListNode dummy = small;
        small.next = head;
        while(head != null) {
            if(head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null; // 为什么？？？
        small.next = half.next; //这里容易错，如果用large的话。large其实是最后一个。
        return dummy.next; //这里容易错
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        n1.next = n2;
        n1 = partition(n1, 1);
        System.out.println(n1.val);
    }
}