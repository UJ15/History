class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length;

        while (i <= j) {
            int mid = i + ((j - i) / 2);

            if (mid >= nums.length || mid < 0) {
                break;
            }

            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return i
    }
}