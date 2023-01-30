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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        int signal = 0;
        int sum = 0;

        while (l1 != null || l2 != null) {
            sum = 0;

            if (signal == 1) {
                signal = 0;
                sum++;
            }

            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }

            int plus = l1.val + l2.val + sum;

            if (plus / 10 > 0) {
                signal = 1;
            }

            sum = (plus % 10);

            result.next = new ListNode(sum);

            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        return temp.next;
    }
}