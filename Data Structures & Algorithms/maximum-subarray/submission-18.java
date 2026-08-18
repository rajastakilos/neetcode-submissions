class Solution {
    public int maxSubArray(int[] nums) {
        int currSubArray = 0;
        int maxSubArray = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currSubArray = Math.max(nums[i], nums[i] + currSubArray);
            maxSubArray = Math.max(maxSubArray, currSubArray);
        }

        return maxSubArray;
    }
}
