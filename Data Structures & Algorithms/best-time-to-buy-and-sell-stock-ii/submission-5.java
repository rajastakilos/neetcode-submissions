class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int dailyProfit = prices[i] - prices[i - 1];
            if (dailyProfit > 0) totalProfit += dailyProfit;
        }

        return totalProfit;
    }
}
// Locally optimal choice does not prevent better Global outcome.