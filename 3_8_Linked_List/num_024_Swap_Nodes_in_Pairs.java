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
class Solution {
    public ListNode swapPairs(ListNode head) { //ex head = [1, 2, 3, 4]
        ListNode result;
        ListNode pre = new ListNode();
        result = pre; //앞의 노드 정보를 위해 초기화
        pre.next = head; //result = [0, 1, 2, 3, 4]
        
        while (head != null && head.next != null){
            ListNode b = head.next; // b == [2, 3, 4]
            head.next = b.next;	   // [1, 2, 3 ,4] -> [1, 3, 4]
            b.next = head;	// b == [2] -> b == [2, 1, 3, 4]
            
            pre.next = b;  //head앞의 노드들을 연결해주기 위함 
	    			// pre == [0, 2, 1, 3, 4]
            
            head = head.next; //head = 3
            pre = pre.next.next;  //pre = 3앞의 1로 
        }
        
        return result.next; //앞의 0을 빼주기 위해 next부터 출력
    }
}
