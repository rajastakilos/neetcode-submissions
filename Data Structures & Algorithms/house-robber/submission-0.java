class Solution {
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return dp(nums, 0);
    }

    private int dp(int[] nums, int i) {
        if (i >= nums.length) return 0;
        if (memo[i] != -1) return memo[i];

        memo[i] = Math.max(dp(nums, i + 1), 
                            nums[i] +
                            dp(nums, i + 2));

        return memo[i];
    }
}
