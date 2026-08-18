class Solution {
    public int singleNumber(int[] nums) {
        int accumulator = 0;
        for (int num : nums) {
            accumulator ^= num;
        }

        return accumulator;
    }
}
