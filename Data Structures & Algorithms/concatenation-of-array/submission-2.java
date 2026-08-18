class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        int j = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[j];

            j = (j == nums.length - 1) ? 0 : j + 1;
        }

        return result;
    }
}