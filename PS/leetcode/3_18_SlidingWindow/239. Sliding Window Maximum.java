class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int j = -1;

        for(int i = 0 ; i < nums.length ; i++) {

            if (!q.isEmpty() && q.getFirst() == i - k) {
                q.removeFirst();
            }

            while (!q.isEmpty() && nums[q.getLast()]<nums[i]) {
                q.removeLast();
            }

            q.addLast(i);

            if (i >= k - 1) {
                ans[++j]=nums[q.getFirst()];
            }
        }
        return ans;
    }
}