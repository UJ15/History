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
    public ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        Collections.sort(list);
        ListNode result = new ListNode();
        ListNode temp = result;

        for (int i = 0 ; i < list.size() ; i++) {
            result.next = new ListNode(list.get(i));
            result = result.next;
        }

        return temp.next;
    }
}