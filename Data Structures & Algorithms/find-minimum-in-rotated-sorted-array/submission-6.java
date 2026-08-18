class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) { // Note: Not left <= right/
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) { // Note: Keep this comp (not left) as canonical for this problem.
                left = mid + 1;
            } else {
                right = mid; // Not - 1. We can accidentally throw out mid if mid was the lowest number. 
            }
        }

        return nums[left]; // Note: while loop ends at left = right. 
    }
}
