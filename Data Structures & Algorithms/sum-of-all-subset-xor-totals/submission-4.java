class Solution {
    private int result = 0;

    public int subsetXORSum(int[] nums) {
        backtrack(0, nums, 0);
        return result;
    }

    private void backtrack(int start, int[] nums, int currXor) {
        for (int i = start; i < nums.length; i++) {
            int newXor = currXor ^ nums[i];   // extend current subset
            result += newXor;                 // add this subset's XOR
            backtrack(i + 1, nums, newXor);   // explore further
        }
    }
}