class Solution {
    private int[] d;

    public int jump(int[] nums) {
        d = new int[nums.length];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        for (int i = 0 ; i < nums.length ; i++) {
            int n = nums[i];

            for (int j = 1 ; j <= n ; j++) {
                if (i + j < nums.length) {
                    d[i + j] = Math.min(d[i] + 1, d[i + j]);
                }
            }
        }

        return d[nums.length - 1];
    }
}