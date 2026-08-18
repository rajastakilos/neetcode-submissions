class Solution {
    public int jump(int[] nums) {
        int length = 0;
        int end = 0;
        int jumps = 0;

        for (int here = 0; here < nums.length - 1; here++) { // nums.length - 1 because we know we can reach end.
            length = Math.max(length, here + nums[here]);
            if (length >= nums.length - 1) return jumps + 1; // Current jumps to reach this level + 1 more to reach end. 

            if (here == end) {
                end = length; // We go up through the current level. 
                jumps++;
            }
        }

        return jumps;
    }
}
// BFS on an array