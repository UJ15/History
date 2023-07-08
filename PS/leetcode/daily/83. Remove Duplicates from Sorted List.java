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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode result = new ListNode();
        ListNode resultHead = result;

        Set<Integer> set = new HashSet<>();

        while (temp != null) {
            if (!set.contains(temp.val)) {
                set.add(temp.val);
                ListNode tempV = new ListNode(temp.val);
                result.next = tempV;
                result = result.next;
            }

            temp = temp.next;
        }

        return resultHead.next;
    }
}