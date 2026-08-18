class Solution {
    public int jump(int[] nums) {
        int farthest = 0;
        int currentEnd = 0;
        int jumps = 0;

        for (int here = 0; here < nums.length - 1; here++) { // nums.length - 1 because we know we can reach end.
            farthest = Math.max(farthest, here + nums[here]);
            if (farthest >= nums.length - 1) return jumps + 1; 

            if (here == currentEnd) {
                currentEnd = farthest;
                jumps++;
            }
        }

        return jumps;
    }
}
// BFS on an array