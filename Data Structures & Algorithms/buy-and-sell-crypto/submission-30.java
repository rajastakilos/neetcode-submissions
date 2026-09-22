class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowestDay = prices[0];

        for (int i = 1; i < prices.length; i++) {
                        lowestDay = Math.min(lowestDay, prices[i]);

            maxProfit = Math.max(maxProfit, prices[i] - lowestDay);
        }

        return maxProfit;
    }
}
