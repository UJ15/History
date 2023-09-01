class Solution {
    public int maxProfit(int[] prices) {
        int minPrice1 = Integer.MAX_VALUE;
        int minPrice2 = Integer.MAX_VALUE;

        int profit1 = 0;
        int profit2 = 0;

        for (int price : prices) {
            minPrice1 = Math.min(price, minPrice1);
            profit1 = Math.max(profit1, price - minPrice1);

            minPrice2 = Math.min(minPrice2, price - profit1);
            profit2 = Math.max(profit2, price - minPrice2);
        }

        return profit2;
    }
}