/**
 * 정렬된 리스트가 파라미터로 들어오기 때문에 현재 리스트 값을 비교해 작은값으로
 * 새로운 리스트를 만들면 된다.
 * 조금 까다로웠던 부분은 리스트 포인터를 넘겨가며 처리하기 때문에 초기 head값을
 * 미리 저장해 두고 있는 부분을 생각해내야 했다.
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode head = result;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                result.next = new ListNode(list2.val);
                result = result.next;
                list2 = list2.next;
                continue;
            }

            if (list2 == null) {
                result.next = new ListNode(list1.val);
                result = result.next;
                list1 = list1.next;
                continue;
            }

            if (list1.val <= list2.val) {
                result.next = new ListNode(list1.val);
                result = result.next;
                list1 = list1.next;
            } else {
                result.next = new ListNode(list2.val);
                result = result.next;
                list2 = list2.next;
            }
        }

        return head.next;
    }
}

/**
 * 재귀를 이용한 풀이
 * 재귀를 이용해서 더 간단한 코드로 풀이가 가능하다.
 * 하지만 직관적으로 이해하기는 쉽지 않다.
 * 머리를 굴려보길
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}