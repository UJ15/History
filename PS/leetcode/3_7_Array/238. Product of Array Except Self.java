class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int p = 1;

        left[0] = p;
        for (int i = 1 ; i < left.length ; i++) {
            p *= nums[i - 1];
            left[i] = p;
        }

        p = 1;
        right[right.length - 1] = p;
        for (int i = right.length - 2 ; i >= 0 ; i--) {
            p *= nums[i + 1];
            right[i] = p;
        }

        for (int i = 0 ; i < nums.length ; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}