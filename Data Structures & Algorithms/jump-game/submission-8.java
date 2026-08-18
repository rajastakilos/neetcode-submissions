class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = nums[0];

        for (int here = 1; here < nums.length; here++) {
             // Optimize: If we know we can reach the end exit early.
            if (maxReach >= nums.length - 1) return true;
            // If we can't get based on previous jumps exit early.
            if (here > maxReach) return false;

            maxReach = Math.max(maxReach, here + nums[here]);
        }

        return true;
    }
}
