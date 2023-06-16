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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp1 = head;
        ListNode temp2 = head;
        int len = 0;

        while (temp2 != null) {
            temp2 = temp2.next;
            len++;
        }

        temp2 = head;

        int prev = 0;

        for (int i = 1 ; i < k ; i++) {
            temp1 = temp1.next;
        }

        for (int i = 0 ; i < len - k ; i++) {
            temp2 = temp2.next;
        }
        int num = temp1.val;
        temp1.val = temp2.val;
        temp2.val = num;

        return head;
    }
}