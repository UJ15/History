import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (ListNode list : lists) {
            while (list != null) {
                heap.offer(list.val);
                list = list.next;
            }
        }

        ListNode result = new ListNode(-1);
        ListNode head = result;

        while (!heap.isEmpty()) {
            result.next = new ListNode(heap.poll());
            result = result.next;
        }

        return head.next;
    }
}