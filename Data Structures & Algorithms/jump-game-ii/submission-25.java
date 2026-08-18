class Solution {
    public int jump(int[] nums) {
        int farthest = 0;
        int levelEnd = 0;
        int jumps = 0;

        for (int here = 0; here < nums.length - 1; here++) { // nums.length - 1 because we know we can reach end.
            farthest = Math.max(farthest, here + nums[here]);
            if (farthest >= nums.length - 1) return jumps + 1; // Current jumps to reach this level + 1 more to reach end. 

            if (here == levelEnd) {
                levelEnd = farthest; // We go up through the current level. 
                jumps++;
            }
        }

        return jumps;
    }
}
// BFS on an array