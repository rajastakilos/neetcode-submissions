class Solution {
    public int maxProfit(int[] prices) {
        int currLow = prices[0];
        int maxProf = 0;

        for (int i = 1; i < prices.length; i++) {
            currLow = Math.min(currLow, prices[i]);
            maxProf = Math.max(maxProf, prices[i] - currLow);
        }

        return maxProf;
    }
}
