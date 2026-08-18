class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int todaysGain = prices[i] - prices[i - 1];

            if (todaysGain > 0) maxProfit += todaysGain;
        }

        return maxProfit;
    }
}
// Greedy = we make a local decision that we never have to revisit, and it still leads to a global optimum