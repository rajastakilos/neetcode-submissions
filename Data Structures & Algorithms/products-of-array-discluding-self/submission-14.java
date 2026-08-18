class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix; 
            prefix *= nums[i];
            // prefix:  1, 1, 2, 8
            // result: [1, 1, 2, 8]
            // nums:   [1, 2, 4, |6]
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
            // suffix:  48 24 6  1
            // result: [48, 24, 12, 8]
            // nums:   [1   2, 4 ,6]
        }

        return result;
    } 
}  
