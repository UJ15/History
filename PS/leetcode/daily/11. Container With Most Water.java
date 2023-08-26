class Solution {
    public int maxArea(int[] height) {
        int result = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        int left = height[i];
        int right = height[j];
        int bucket = 0;
        int water = 0;

        while (i < j) {
            left = height[i];
            right = height[j];
            bucket = Math.min(left, right);
            water = (j - i) * bucket;

            result = Math.max(result, water);

            if (left <= right) {
                i++;
            } else {
                j--;
            }
        }

        return result;
    }
}