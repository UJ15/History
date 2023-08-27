class Solution {

    public int wiggleMaxLength(int[] nums) {
        int wiggle = 0;
        int len = 0;

        for (int i = 0 ; i < nums.length - 1 ; i++) {
            int diff = nums[i] - nums[i + 1];

            if (diff < 0 && wiggle != 1) {
                wiggle = 1;
                len++;
            } else if (diff > 0 && wiggle != -1) {
                wiggle = -1;
                len++;
            }
        }

        return len + 1;
    }
}