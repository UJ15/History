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

/**
 * 요롷게도 풀리긴 하네
 */
class Solution {
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        while (head != null) {
            heap.offer(head.val);
            head = head.next;
        }

        ListNode result = new ListNode();
        ListNode temp = result;

        while (!heap.isEmpty()) {
            result.next = new ListNode(heap.poll());
            result = result.next;
        }

        return temp.next;
    }
}
/**
 * 병합 정렬 알고리즘을 통한 풀이
 */

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
    private ListNode result = new ListNode();
    private ListNode temp = result;

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode half = null;
        ListNode faster = head;

        while (faster != null && faster.next != null) {
            half = slow;
            slow = slow.next;
            faster = faster.next.next;
        }

        half.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode result = new ListNode(0);
        ListNode fin = result;

        while(left != null && right != null){
            if(left.val > right.val){
                result.next = right;
                right = right.next;
            }
            else{
                result.next = left;
                left = left.next;
            }
            result = result.next;
        }

        while(left != null){
            result.next = left;
            left = left.next;
            result = result.next;
        }

        while(right != null){
            result.next = right;
            right = right.next;
            result = result.next;
        }

        return fin.next;
    }
}