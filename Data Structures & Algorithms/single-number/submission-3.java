class Solution {
    public int singleNumber(int[] nums) {
        int acc = 0;
        for (int num : nums) acc ^= num;
        return acc;
    }
}

// nums = [4, 1, 2, 1, 2]
// 4 ^ (1 ^ 1) ^ (2 ^ 2)
// 4 ^ (0 ^ 0)
// 4 ^ 0 = 4;