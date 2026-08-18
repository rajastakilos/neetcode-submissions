class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixArr = new int[nums.length];
        prefixArr[0] = 1;
        int[] suffixArr = new int[nums.length];
        suffixArr[suffixArr.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefixArr[i] = prefixArr[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            suffixArr[i] = suffixArr[i + 1] * nums[i + 1]; 
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