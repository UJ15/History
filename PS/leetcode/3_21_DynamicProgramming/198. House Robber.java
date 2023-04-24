/**
 * 이웃한 인덱스를 선택할 수 없을때 최대합을 구하는 문제,
 * d[] 배열에 현재 인덱스를 포함시켰을때와 포함시키지 않았을때를 비교하며 타뷸레이션을 진행하면 된다.
 */

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[n - 1];
        }

        int[] d = new int[n];
        d[0] = nums[0];
        d[1] = Math.max(nums[0], nums[1]);

        for (int i = 2 ; i < n ; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + nums[i]);
        }

        return d[n - 1];
    }
}