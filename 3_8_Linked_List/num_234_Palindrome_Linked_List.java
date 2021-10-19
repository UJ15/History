/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution { //런너 기법으로 풀이
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null; //slow와 fast러너, 중간지점까지 리스트를 담을 prev
        
        while (fast != null && fast.next != null){//리스트 길이가 짝수거나 홀수일 경우
            fast = fast.next.next; //2칸 씩 이동
            
            ListNode nextNode = slow.next;// Temp에 slow.next저장
            slow.next = prev; //next를 prev로 대입해서 리스트를 거꾸로
            prev = slow;
            slow = nextNode;
        }
        
        ListNode left = prev;
        ListNode right = fast == null ? slow : slow.next; // fast가 null이면 길이가 짝수 fast,next가 null이면 길이가 홀수
							//홀수일 경우중간값을 뺀  slow.next부터 비교
        
        while (right != null){
            if (left.val != right.val){
                return false;
            }
            
            left = left.next;
            right = right.next;
        }
        
        return true;
    }
}
