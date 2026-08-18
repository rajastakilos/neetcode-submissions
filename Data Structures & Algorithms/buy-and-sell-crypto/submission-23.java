class Solution {
    public int maxProfit(int[] prices) {
        int currLow = Integer.MAX_VALUE;
        int maxProf = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            currLow = Math.min(currLow, prices[i]);
            maxProf = Math.max(maxProf, prices[i] - currLow);
        }

        return maxProf;
    }
}
