class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        
        int jumps = 1; // Pre-count the first jump
        int maxReach = nums[0];
        int currentEnd = nums[0];

        for (int i = 1; i < nums.length - 1; i++) { // nums.length - 1. Stop before last index.
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = maxReach;
            }
        }

        return jumps;
    }
}
