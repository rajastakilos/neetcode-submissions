class Solution {
    public int maxProfit(int[] prices) {
        int totalGain = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalGain += prices[i] - prices[i - 1];
            }
        }

        return totalGain;
    }
}