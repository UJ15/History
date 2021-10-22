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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();//결과 노드
        ListNode prev = null;// 앞의 노드 정보 저장
        int pass = 0;
    
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        
        insert(prev, result, l1, l2, pass);
        
        return result;
        
    }//앞자리를 더해주면서 10을 넘을경우 뒤로 1을 넘겨주고 아닐경우 그대로
    //result 리스트에 추가
    public void insert(ListNode prev, ListNode head, ListNode l1, ListNode l2, int pass){
        if (l1 != null && l2 != null){
            ListNode nextNode = new ListNode();
            int sum = pass + l1.val + l2.val;
            if (sum < 10){
                pass = 0;
                head.val = sum;
                head.next = nextNode;
                prev = head;
                insert(prev, head.next, l1.next, l2.next, pass);
            }
            else{
                pass = 1;
                head.val = sum % 10;
                head.next= nextNode;
                prev = head;
                insert(prev, head.next, l1.next, l2.next, pass);
            }
        }
        else if(l1 != null && l2 == null){
            ListNode nextNode = new ListNode();
            int sum = pass + l1.val;
            if (sum < 10){
                pass = 0;
                head.val = sum;
                head.next = nextNode;
                prev = head;
                insert(prev, head.next, l1.next, l2, pass);
            }
            else {
                pass = 1;
                head.val = sum % 10;
                head.next = nextNode;
                prev = head;
                insert(prev, head.next, l1.next, l2, pass);
            }
        }
        else if(l1 == null && l2 != null){
            ListNode nextNode = new ListNode();
            int sum = pass + l2.val;
            if (sum < 10){
                pass = 0;
                head.val = sum;
                head.next = nextNode;
                prev = head;
                insert(prev, head.next, l1, l2.next, pass);
            }
            else{
                pass = 1;
                head.val = sum % 10;
                head.next = nextNode;
                prev = head;
                insert(prev, head.next, l1, l2.next, pass);
            }
        }
        else {
            if (pass == 1){
                head.val = 1;
                head.next = null;
            }else{
                prev.next = null;
            }
        }
    }
}
