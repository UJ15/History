/**
 * fast runner 와 slow runner를 활용한 풀이다
 * 연결리스트가 나오면 해당 기법을 연상시켜보자
 * fast runner는 연결리스트의 위치를 파악하는 용도로 쓰인다.
 * (fast runner가 도착했다면 slow의 위치는 중간)
 * 이 기법으로 역순 리스트를 (slow기준)만들어 나머지 slow들과 비교한다.
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
import java.util.*;

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;
        ListNode reverse = null;

        if (head.next == null) {
            return true;
        }

        while (faster != null && faster.next != null) {
            reverse = new ListNode(slower.val, reverse);
            slower = slower.next;
            faster = faster.next.next;
        }
/**
 * 해당 라인은 리스트길이가 짝수인지 홀수인지에 따라 팰린드롬 검증과정을 생략하는 코드다
 * faster가 null이 아니라면 길이가 홀수를 뜻하는것이고 그에따라 중간숫자를 생략하기 위해 slow를 한칸 옮겨준다.
 */
        if (faster != null) {
            slower = slower.next;
        }

        while (slower != null) {
            if (reverse.val != slower.val) {
                return false;
            }

            reverse = reverse.next;
            slower = slower.next;
        }

        return true;
    }
}