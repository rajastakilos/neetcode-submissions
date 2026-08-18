class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;

        while (sell < prices.length) {
            if (prices[sell] > prices[buy]) {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            } else {
                buy = sell;    
            }
            sell++;
        }

        return maxProfit;
    }
}
