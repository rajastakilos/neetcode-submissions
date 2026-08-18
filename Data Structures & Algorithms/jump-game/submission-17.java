class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int here = 0; here < nums.length; here++) {
            // if (maxReach > nums.length - 1) return true; // Can we reach end now?
            if (here > maxReach) return false; // Can we reach this spot now?

            maxReach = Math.max(maxReach, here + nums[here]); // 
        }

        return true;
    }
}
