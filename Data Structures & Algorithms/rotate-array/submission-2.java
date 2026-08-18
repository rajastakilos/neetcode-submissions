class Solution {
    public void rotate(int[] nums, int k) {
        // [1,2,3,4,5,6,7]
        k %= nums.length; // Effective number of rotations. 
        reverse(nums, 0, nums.length - 1); // reverse whole array: [7,6,5,4,3,2,1]]
        reverse(nums, 0, k - 1); // Reverse first k elements: [5,6,7,4,3,2,1]
        reverse(nums, k, nums.length - 1); // Reverse remaining elements: [5,6,7,1,2,3,4]
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            // int leftVal = nums[left];
            // int rightVal = nums[right];
            // nums[left] = rightVal;
            // nums[right] = leftVal;
            
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;

            left++;
            right--;
        }
    }
}