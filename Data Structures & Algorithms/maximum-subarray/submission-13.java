class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxValue = Integer.MIN_VALUE;

        for (int num : nums) {
            currentSum = Math.max(num, num + currentSum);
            maxValue = Math.max(maxValue, currentSum);
        }

        return maxValue;
    }
}
