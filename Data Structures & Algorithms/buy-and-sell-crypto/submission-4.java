class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = 0;
        int sell = 1;
        while (sell < prices.length) {
            if (prices[sell] > prices[buy]) {
                maxProfit = Math.max(prices[sell] - prices[buy], maxProfit);
            } else if (prices[buy] > prices[sell]) {
                buy = sell; // Move buy forward.
            }
            sell++; // Move every iteration.
        }

        return maxProfit;
    }
}
