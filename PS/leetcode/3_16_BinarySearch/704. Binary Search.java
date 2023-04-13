class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int mid = len / 2;
        int end = len - 1;
        int result = -1;

        while (start <= end) {
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target){
                end = mid - 1;
            } else {
                result = mid;
                break;
            }

            mid = start + (end - start) / 2;
        }

        return result;
    }
}