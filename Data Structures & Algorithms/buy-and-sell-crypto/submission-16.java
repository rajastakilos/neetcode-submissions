class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentLow = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            currentLow = Math.min(currentLow, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - currentLow);
        }

        return maxProfit;
    }
}
