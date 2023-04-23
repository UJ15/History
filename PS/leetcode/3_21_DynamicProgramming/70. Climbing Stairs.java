class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] d = new int[n + 1];

        d[0] = 0;
        d[1] = 1;
        d[2] = 2;

        for (int i = 3 ; i <= n ; i++) {
            d[i] = d[i - 2] + d[i - 1];
        }

        return d[n];
    }
}