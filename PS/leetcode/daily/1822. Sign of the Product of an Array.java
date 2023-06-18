class Solution {
    public int arraySign(int[] nums) {
        int negative = 0;

        for (int num : nums) {
            if (num == 0) {
                return 0;
            }

            if (num < 0) {
                negative++;
            }
        }

        System.gc();

        return negative % 2 == 0 ? 1 : -1;
    }
}