class Solution {
    public int jump(int[] nums) {
        int farthest = 0;
        int currentEnd = 0;
        int jumps = 0;

        for (int here = 0; here < nums.length - 1; here++) { // Super Important: nums.length - 1;
            farthest = Math.max(farthest, here + nums[here]);

            if (here == currentEnd) {
                currentEnd = farthest;
                jumps++;
            }
        }

        return jumps;
    }
}
