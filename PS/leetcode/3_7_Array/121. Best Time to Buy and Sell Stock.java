/*
배열 원소 순서대로 최소값과 최대값의 차이를 구하는 문제
인덱스를 뒤에서 부터 탐색하면 간단하게 해결된다.
 */

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int max = -1;

        for (int i = prices.length - 1 ; i >= 0 ; i--) {
            max = Math.max(max, prices[i]);
            profit = Math.max(profit, max - prices[i]);
        }

        return profit;
    }
}

/*
사실 앞에서부터 최솟값과 최대 이익을 갱신하며 풀어도 잘 풀린다. ㅎㅎ 이게 책 풀이

 */
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0 ; i < prices.length ; i++) {
            min = Math.min(prices[i], min);
            profit = Math.max(prices[i] - min, profit);
        }

        return profit;
    }
}