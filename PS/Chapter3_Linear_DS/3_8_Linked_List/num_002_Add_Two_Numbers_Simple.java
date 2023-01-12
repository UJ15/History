class Solution {
    /* 내코드는 너무 쓸데없이 복잡해서 다른 사람의 코드를 봤다
     * This list node uses for optimize memory usage
     */
    private static final ListNode ZERO_NODE = new ListNode(0);
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recursiveSum(l1, l2, 0);
    }

    /*
     * Calculate sum of node values recursively
     *
     * @param a     first node
     * @param b     second node
     * @param carry the number from the last addition
     * @return calculated list node
     */
    private ListNode recursiveSum(ListNode a, ListNode b, int carry) {
        int sum = (a.val + b.val) + carry;
        int newCarry = sum / 10;

        ListNode r = new ListNode(sum % 10);
        if (a.next == null && b.next == null) {
            if (newCarry > 0) {
                r.next = new ListNode(newCarry);
            }
        } else {
            r.next = recursiveSum(
                    (a.next == null) ? ZERO_NODE : a.next,
                    (b.next == null) ? ZERO_NODE : b.next, newCarry);
        }

        return r;
    }    
}
