class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (maxReach > nums.length - 1) return true;

            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}
