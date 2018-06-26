package leetcode_basic.class21_PracticeII;

import leetcode_basic.class0.ListNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode merge(List<ListNode> listOfNodes) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(11, new MyComparator());
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(ListNode node : listOfNodes) {
            if(node != null) {
                minHeap.offer(node);
            }
        }
        while(!minHeap.isEmpty()) {
            cur.next = minHeap.poll();
            if(cur.next.next != null) {
                minHeap.offer(cur.next.next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    static class MyComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            if(o1.value == o2.value) {
                return 0;
            }
            return o1.value < o2.value ? -1:1;
        }
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);

        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(6);

        n1.next = n2; n2.next = n3;
        n4.next = n5; n5.next = n6;
        List<ListNode> listNodes = new LinkedList<ListNode>();
        listNodes.add(n1);
        listNodes.add(n4);
        ListNode res = mergeKSortedLists.merge(listNodes);
        System.out.println(10);
    }

}
