class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Biggest possible value so that the first price replaces it.
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            int profit = price - minPrice;
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }
}
