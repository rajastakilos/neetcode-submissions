class Solution {
    public int maxProfit(int[] prices) {
        int totalGain = 0;

        for (int i = 1; i < prices.length; i++) {
            int saleProfit = prices[i] - prices[i - 1];
            if (saleProfit > 0) {
                totalGain += saleProfit;
            }
        }

        return totalGain;
    }
}
// Locally optimal choice does not prevent better Global outcome.