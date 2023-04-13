class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = (nums.length - 1) / 2;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int pivot = left;

        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            int midPivot = (mid + pivot) % nums.length;

            if (nums[midPivot] < target) {
                left = mid + 1;
            } else if (nums[midPivot] > target) {
                right = mid - 1;
            } else {
                return midPivot;
            }
        }

        return -1;
    }
}