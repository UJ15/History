class Solution {
    public int triangleNumber(int[] nums) {
        int result = 0;
        int last = nums.length - 1;
        Arrays.sort(nums);

        for (int i = 0 ; i < nums.length - 2 ; i++) {
            for (int j = i + 1 ; j < nums.length - 1 ; j++) {
                int sum = nums[i] + nums[j];
                for (int k = j + 1 ; k < nums.length ; k++) {
                    if (sum > nums[k]) {
                        result++;
                    } else {
                        break;
                    }
                }
            }
        }

        return result;
    }
}