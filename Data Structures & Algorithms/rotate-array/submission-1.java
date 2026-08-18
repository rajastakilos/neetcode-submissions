class Solution {
    public void rotate(int[] nums, int k) {
        // if (nums.length == 0 || k == 0) return;

        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1); 

   
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int leftVal = nums[left];
            int rightVal = nums[right];
            nums[left] = rightVal;
            nums[right] = leftVal;

            left++;
            right--;
        }
    }
}