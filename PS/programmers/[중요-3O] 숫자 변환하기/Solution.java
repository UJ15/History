//내풀이
//https://school.programmers.co.kr/learn/courses/30/lessons/154538
import java.util.*;

class Solution {
    private int[] d;
    public int solution(int x, int y, int n) {
        int count = 0;
        d = new int[y + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[x] = 0;
        if (x + n <= y) {
            d[x + n] = 1;
        }

        if (x * 2 <= y) {
            d[x * 2] = 1;
        }

        if (x * 3 <= y) {
            d[x * 3] = 1;
        }

        for (int i = x ; i <= y ; i++) {
            if (i - n >= x && d[i - n] != Integer.MAX_VALUE) {
                d[i]  = Math.min(d[i - n] + 1, d[i]);
            }

            if (i % 2 == 0 && d[i / 2] != Integer.MAX_VALUE) {
                d[i] = Math.min(d[i / 2] + 1, d[i]);
            }

            if (i % 3 == 0 && d[i / 3] != Integer.MAX_VALUE) {
                d[i] = Math.min(d[i / 3] + 1, d[i]);
            }
        }

        return d[y] == Integer.MAX_VALUE ? -1 : d[y];
    }
}

/**
 * short code
 */

import java.util.*;

class Solution {

    int[] dp = new int[3000003];
    int INF = 1000002;

    public int solution(int x, int y, int n) {
        int answer = 0;
        Arrays.fill(dp, INF);
        dp[x] = -1;
        dp[y] = 0;
        for(int num = Math.max(y - n, Math.max(y / 2, y / 3)); num >= x; num--){
            dp[num] = Math.min(dp[num + n] + 1, Math.min(dp[num * 2] + 1, dp[num * 3] + 1));
        }
        return dp[x] >= INF ? -1 : dp[x];
    }
}