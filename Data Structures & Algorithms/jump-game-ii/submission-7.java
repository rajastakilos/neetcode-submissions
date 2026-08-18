class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0; // We are here.

        int maxReach = nums[0];
        int jumps = 1;
        int currentEnd = nums[0];

        for (int i = 1; i < nums.length - 1; i++) { // nums.length - 1. Stop before last index.
            // We can always reach every index, so no guard for i > maxReach like with Jump 1. 
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == currentEnd) { // Tracks minimum number of jumps. 
                jumps++;
                currentEnd = maxReach;
            }
        }

        return jumps;
    }
}

// Greedy Property: At each step, we pick the jump that maximizes future reach — but only when we are forced to commit