class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            currentSum = Math.max(num, num + currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
