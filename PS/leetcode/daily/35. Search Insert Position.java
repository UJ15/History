class Solution {
    public int searchInsert(int[] nums, int target) {
        int result = 0;
        int i = 0;
        int j = nums.length;
        int mid = 0;

        while (i <= j) {
            mid = i + ((j - i) / 2);

            if (mid >= nums.length || mid < 0) {
                break;
            }

            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                result = mid;
                break;
            }
        }

        if (i > j) {
            return i;
        } else {
            return mid;
        }

    }
}