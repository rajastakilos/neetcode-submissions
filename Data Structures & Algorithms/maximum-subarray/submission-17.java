class Solution {
    public int maxSubArray(int[] nums) {
        int largestSum = Integer.MIN_VALUE;
        int currentLargest = 0;

        for (int num : nums) {
            currentLargest = Math.max(num, num + currentLargest);
            largestSum = Math.max(largestSum, currentLargest);
        }
        
        return largestSum;
    }
}
