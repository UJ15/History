/**
 * DP풀이 -> 하위 인덱스가 아닌 상위 인덱스에서 내려가면서 해를 찾는 것이 포인트다.
 *
 */

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];

        for (int i = n - 2 ; i >= 0 ; i--) {
            int next = i + questions[i][1] + 1;
            long take = 0;

            if (next < n) {
                take = dp[next];
            }

            dp[i] = Math.max(dp[i + 1], take + questions[i][0]);
        }

        return dp[0];
    }
}