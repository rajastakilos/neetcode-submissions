class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int currentMaxProduct = 1;
        int currentMinProduct = 1;

        for (int num : nums) {
            int tempMax = currentMaxProduct;
            currentMaxProduct = Math.max(num, Math.max(
                num * tempMax, num * currentMinProduct
            ));
            currentMinProduct = Math.min(num, Math.min(
                num * tempMax, num * currentMinProduct
            ));
            
            maxProduct = Math.max(maxProduct, currentMaxProduct);
        }

        return maxProduct;
    }
}
