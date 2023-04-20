class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int profit = 0;

        for (int i = prices.length - 1 ; i >= 0 ; i--) {
            if (max <= prices[i]) {
                max = prices[i];
            } else {
                profit += max - prices[i];
                max = prices[i];
            }
        }

        return profit;
    }
}

/**
 * Greedy
 */

class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;

        for (int i = 0 ; i < prices.length - 1 ; i++) {
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }

        return result;
    }
}