class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;

            if (nums[mid] > nums[right]) { // Pivot is right of mid. 
                // Keep side with target in it.
                if (target >= nums[left] && target < nums[mid]) { // Sorted Side
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // Pivot is left of mid.
                // Keep side with target in it.
                if (target <= nums[right] && target > nums[mid]) { // Sorted Side
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
        }

        return -1;
    }
}
// Time: O (log n). We reduce up to half the array at a time.
// Space: O(1). We create no new collections.
