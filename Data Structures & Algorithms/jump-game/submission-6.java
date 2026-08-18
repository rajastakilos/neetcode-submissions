class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = nums[0];

        for (int here = 1; here < nums.length; here++) {
            if (maxReach >= nums.length) return true;

            if (here > maxReach) return false;
            maxReach = Math.max(maxReach, here + nums[here]);
        }

        return true;
    }
}
