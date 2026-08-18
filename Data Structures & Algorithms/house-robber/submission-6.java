class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        // int[] dp = new int[nums.length];
        int take = nums[0];
        int skip = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(skip, nums[i] + take);
            take = skip;
            skip = temp;
        }

        return Math.max(skip, take);
    }
}
