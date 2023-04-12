class Solution {
    public String largestNumber(int[] nums) {
        int i = 1;

        while (i < nums.length) {
            int j = i;

            while (j > 0 && toSwap(nums[j - 1], nums[j])) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
            i++;
        }

        String s = "";

        if (nums[0] == 0) {
            return "0";
        }

        for (int num : nums) {
            s += num;
        }

        return s;
    }

    private boolean toSwap(int a, int b) {
        String s1 = a + "" + b;
        String s2 = b + "" + a;

        return Long.parseLong(s1) < Long.parseLong(s2);
    }
}