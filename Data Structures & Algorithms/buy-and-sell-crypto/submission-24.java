class Solution {
    public int maxProfit(int[] prices) {
        int lowestDay = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            lowestDay = Math.min(lowestDay, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - lowestDay);
        }

        return maxProfit;
    }
}
