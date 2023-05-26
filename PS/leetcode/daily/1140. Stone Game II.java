//누적합 + 2차원 dp 타뷸레이션 미친거아니야?

class Solution {
    public int stoneGameII(int[] piles) {
        int[][] d = new int[piles.length][piles.length];

        int[] suffixSum = new int[piles.length];
        suffixSum[suffixSum.length - 1] = piles[piles.length - 1];

        for (int i = piles.length - 2 ; i >= 0 ; i--) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }

        return dfs(piles, suffixSum, d, 0, 1);
    }

    private int dfs(int[] piles, int[] suffixSum, int[][] d, int firstPile, int M) {
        if (firstPile == piles.length) {
            return 0;
        }

        if (piles.length - firstPile <= 2 * M) {
            return suffixSum[firstPile];
        }

        if (d[firstPile][M] != 0) {
            return d[firstPile][M];
        }

        int result = 0;

        for (int x = 1 ; x <= 2 * M ; x++) {
            result = Math.max(result, suffixSum[firstPile] - dfs(piles, suffixSum, d, firstPile + x, Math.max(M, x)));
        }

        d[firstPile][M] = result;
        return result;
    }
}