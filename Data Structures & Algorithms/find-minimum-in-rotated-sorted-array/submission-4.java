class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // if (left == right) return nums[left];

            if (nums[mid] > nums[right]) { // Keep this comp (not left) as canonical for this problem.
                left = mid + 1;
            } else {
                right = mid; // Not - 1. We can accidentally throw out mid if mid was the lowest number. 
            }
        }

        return nums[left]; // Throw an error. 
    }
}
