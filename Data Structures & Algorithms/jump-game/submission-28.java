class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int here = 0; here < nums.length; here++) {
            if (farthest < here) return false;
            if (farthest >= nums.length) return true;
            farthest = Math.max(farthest, here + nums[here]);
        }

        return true;
    }
}
