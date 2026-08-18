class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0]; // Biggest possible value so that the first price replaces it.
        int maxProfit = 0;

        for (int price : prices) {
            minPrice =  Math.min(price, minPrice);
            maxProfit = Math.max(price - minPrice, maxProfit);
        }

        return maxProfit;
    }
}
