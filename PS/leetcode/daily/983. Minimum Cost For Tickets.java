class Solution {
    private int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        Arrays.fill(dp, -1);
        return minCostTickets(0, days, costs);
    }

    private int minCostTickets(int index, int[] days, int[] costs) {
        if(index >= days.length) {
            return 0;
        }

        if(dp[index] != -1) {
            return dp[index];
        }
        int oneDayTicket = minCostTickets(index+1, days, costs) + costs[0];

        int next = Arrays.binarySearch(days, days[index] + 7);
        if(next < 0) {
            next = -(next+1);
        }

        int sevenDaysTicket = minCostTickets(next, days, costs) + costs[1];

        next = Arrays.binarySearch(days, days[index] + 30);
        if(next < 0) {
            next = -(next+1);
        }
        int thirtyDaysTicket = minCostTickets(next, days, costs) + costs[2];

        return dp[index] = Math.min(oneDayTicket, Math.min(sevenDaysTicket, thirtyDaysTicket));
    }
}