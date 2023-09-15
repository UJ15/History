class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0 ; i < k ; i++) {
            if (i >= nums.length) {
                break;
            }

            if (!q.isEmpty() && set.contains(nums[i])) {
                return true;
            }

            q.offer(nums[i]);
            set.add(nums[i]);
        }

        for (int i = k ; i < nums.length ; i++) {
            if (!q.isEmpty() && set.contains(nums[i])) {
                return true;
            }
            q.offer(nums[i]);
            set.add(nums[i]);
            set.remove(q.poll());
        }

        return false;
    }
}