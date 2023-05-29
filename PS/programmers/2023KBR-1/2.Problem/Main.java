import java.util.*;

class Solution {
    private int ePlus;
    private int sales;

    public int[] solution(int[][] users, int[] emoticons) {
        ePlus = 0;
        sales = 0;

        dfs(new ArrayList<>(), users, emoticons);

        return new int[] {ePlus, sales};
    }

    private void dfs(List<Integer> discountRate, int[][] users, int[] emoticons) {
        if (discountRate.size() == emoticons.length) {
            comparePrice(discountRate, users, emoticons);
            return;
        }

        for (int i = 0 ; i <= 4 ; i++) {
            discountRate.add(i);
            dfs(discountRate, users, emoticons);
            discountRate.remove(discountRate.size() - 1);
        }
    }

    private void comparePrice(List<Integer> discountRate, int[][] users, int[] emoticons) {
        int s = 0;
        int e = 0;

        int[] prices = new int[emoticons.length];
        for (int i = 0 ; i < emoticons.length ; i++) {
            prices[i] = emoticons[i] - (emoticons[i] / 10) * discountRate.get(i);
        }

        for (int[] user : users) {
            int userPrice = 0;

            for (int i = 0 ; i < prices.length ; i++) {
                if (user[0] <= discountRate.get(i) * 10) {
                    userPrice += prices[i];
                }
            }

            if (userPrice >= user[1]) {
                e++;
            } else {
                s += userPrice;
            }
        }

        if (ePlus < e || (ePlus == e && sales < s)) {
            ePlus = e;
            sales = s;
        }
    }
}