class Solution {
    public int jump(int[] nums) {
        int farthest = 0;
        int jumps = 0;
        int levelEnd = 0;

        for (int here = 0; here < nums.length - 1; here++) {
            farthest = Math.max(farthest, here + nums[here]);
            if (farthest >= nums.length - 1) return ++jumps;
            if (here == levelEnd) {
                jumps++;
                levelEnd = farthest;
            }
        }

        return jumps;
    }
}
// [2 4 1] 1 1 1
// 2 [4 1 1 1 1]
// 2 4 [1] 1 1 1