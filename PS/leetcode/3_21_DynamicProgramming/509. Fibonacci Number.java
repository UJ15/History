/**
 * DP(Tabulation)
 * BottomUp
 */

class Solution {
    public int fib(int n) {
        int[] d = new int[n + 1];

        if (d.length == 1) {
            return 0;
        }

        d[0] = 0;
        d[1] = 1;

        for (int i = 2 ; i <= n ; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        return d[n];
    }
}

/**
 * memoization
 * TopDown
 */

class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}