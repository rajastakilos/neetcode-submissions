class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int lowestPrice = Integer.MAX_VALUE;
        
        for (int price : prices) {
            lowestPrice = Math.min(lowestPrice, price);
            maxProfit = Math.max(maxProfit, price - lowestPrice);
        }

        return maxProfit;
    }
}
