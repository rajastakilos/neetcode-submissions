class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = nums[0];
        int nextReach = nums[0];
        
        for (int here = 1; here < nums.length; here++) {
            int nextJumps = nums[here];
            // if (maxReach >= nums.length - 1) return true; // Return early if we can get there.
            if (maxReach < here) return false; // We cannot reach this spot.            

            nextReach = here + nextJumps; 
            maxReach = Math.max(maxReach, nextReach);
        } 

        return true;
    }
}
