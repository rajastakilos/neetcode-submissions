class Solution {
    private int[] memo; // what is the best answer starting from house i?

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return dp(nums, 0); // maximum money we can rob starting from house i onward
    }

    private int dp(int[] nums, int i) {
        if (i >= nums.length) return 0;
        if (memo[i] != -1) return memo[i];
        // memo: best total from that position onward.
        memo[i] = Math.max(dp(nums, i + 1), // skip
                            nums[i] +
                            dp(nums, i + 2)); // rob it

        return memo[i];
    }
}
