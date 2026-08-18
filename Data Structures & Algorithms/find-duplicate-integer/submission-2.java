class Solution {
    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) return idx;

            nums[idx] = -nums[idx];
        }
        return 0; // Throw. Given constraints of question we should never return 0.
    }
}
