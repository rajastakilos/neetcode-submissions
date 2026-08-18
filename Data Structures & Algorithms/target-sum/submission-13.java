class Solution {
    private int differentWays = 0; // TODORAJAS: use this outside of class.
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(0, 0, target, nums);
        return differentWays;
    }

    private void backtrack(int idx, int currentSum, int target, int[] nums) {
        if (idx == nums.length) {
            if (target == currentSum) {
                differentWays++;
                return;
            }
        } else {
            backtrack(idx + 1, currentSum - nums[idx], target, nums);
            backtrack(idx + 1, currentSum + nums[idx], target, nums);
        }
    }
}
