class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        int j = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[j];

            if (j == nums.length - 1) {
                j = 0;
            } else {
                j++;
            }
        }

        return result;
    }
}