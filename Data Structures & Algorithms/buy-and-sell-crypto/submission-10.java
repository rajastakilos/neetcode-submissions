class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // or prices[0] but makes for loop start from i = 1.
        int maxProfit = 0;

        for (int price : prices) {
            minPrice =  Math.min(price, minPrice);
            maxProfit = Math.max(price - minPrice, maxProfit);
        }

        return maxProfit;
    }
}
