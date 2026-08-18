class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(helper(0, nums.length - 2, nums), 
                        helper(1, nums.length - 1, nums));
    }

    private int helper(int start, int end, int[] nums) {
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int temp = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}
