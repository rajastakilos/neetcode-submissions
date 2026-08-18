class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length]; // result = product of everything to the left x product of everything to the right.
        result[0] = 1;

        int prefixProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixProduct; // Product of everything to the left...
            prefixProduct *= nums[i];
        }

        int suffixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffixProduct; // ...X Product of everything to the right.
            suffixProduct *= nums[i];
        }

        return result;
    }
}  
