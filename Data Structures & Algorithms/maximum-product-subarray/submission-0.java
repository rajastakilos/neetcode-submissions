class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int currentMin = 1;
        int currentMax = 1;

        for (int num : nums) {
            int tmp = currentMax * num;
            currentMax = Math.max(
                            Math.max(num * currentMax, num * currentMin), 
                            num);

            currentMin = Math.min(
                            Math.min(tmp, num * currentMin),
                            num);
            result = Math.max(result, currentMax);
        }

        return result;
    }
}
