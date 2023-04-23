/**
 * dp 풀이
 * 현재까지의 합과 현재 숫자를 더한 값보다 현재값이 더 크다면 현재값을 현재까지의 합으로.
 * 그 중 최대값을 구하면 된다.
 * 즉 덧셈을 시작하는 인덱스를 두고 더해나가다가 값이 작아지는 분기점에 시작 인덱스를 변경하는 방식이다.
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int[] d = new int[nums.length];
        d[0] = nums[0];
        int max = d[0];

        for (int i = 1 ; i < nums.length ; i++) {
            d[i] = Math.max(d[i - 1] + nums[i], nums[i]);
            max = Math.max(max, d[i]);
        }

        return max;
    }
}