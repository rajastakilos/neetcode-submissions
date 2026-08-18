class Solution {
    public int maxSubArray(int[] nums) {
        int largestSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            largestSum = Math.max(largestSum, currentSum);
        }

        return largestSum;
    }
}
