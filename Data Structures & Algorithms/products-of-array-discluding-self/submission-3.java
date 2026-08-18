class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixArr = new int[nums.length];
        int[] suffixArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            prefixArr[i] = i == 0 ? 
                1 : prefixArr[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            suffixArr[i] = i == nums.length - 1 ? 
                1 : suffixArr[i + 1] * nums[i + 1]; 
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixArr[i] * suffixArr[i];
        }

        return result;
    }
}
// Time: O(n): Touch each element once in each of the first two loops. 
    // Touch each element in the prefix and suffix arrays once per iteration. Add up
    // multiple O(n) operations.
// Space: O(n). Created two new collections of the same size as the input array.