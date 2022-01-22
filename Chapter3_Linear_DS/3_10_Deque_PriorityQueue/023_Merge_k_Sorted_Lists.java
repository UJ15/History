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
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        ListNode result = null;
        int n = lists.length;
		//Max heap 우선순위 큐를 만들고 모든 리스트 값을 넣고 큐에서 하나씩 poll해 연결한다.        
        for (int i = 0 ; i < n ; i++)
        {
            while (lists[i] != null){
                heap.offer(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        
        n = heap.size();
        
        for (int i = 0 ; i < n ; i++){
            if (result == null){
                result = new ListNode(heap.poll());
            }else{
                result = new ListNode(heap.poll(), result);
            }
        }
        
        return result;
    }
}

