class KthLargest {
    private PriorityQueue<Integer> q;
    private int kth;

    public KthLargest(int k, int[] nums) {
        this.q = new PriorityQueue<>((a, b) -> b - a);
        this.kth = k;

        for (int n : nums) {
            q.offer(n);
        }
    }

    public int add(int val) {
        q.offer(val);
        PriorityQueue<Integer> temp = new PriorityQueue<>(q);

        for (int i = 0 ; i < kth - 1; i++) {
            temp.poll();
        }

        return temp.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */