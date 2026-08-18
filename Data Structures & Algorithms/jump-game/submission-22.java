class Solution {
    public boolean canJump(int[] nums) {
        int farthest = nums[0];

        for (int here = 1; here < nums.length; here++) {
            if (farthest < here) return false;

            farthest = Math.max(farthest, here + nums[here]);
        }

        return true;
    }
}
