class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[right]) { // Look for pivot like in Find Min in rotated sorted array.
                // nums = [4,5,6,7,0,1,2]
                // left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    // Example target = 5
                    // Check: 5 >= 4 && 5 < 7  => true
                    // So target is inside the sorted left half [4,5,6]. Discard [7,0,1,2]
                    right = mid - 1;
                } else {
                    // Example target = 1
                    // Check: 1 >= 4 && 1 < 7  => false
                    // So target is NOT inside the sorted left half. It must be in the other half.
                    // Keep [0,1,2]. Discard [4,5,6,7]
                    left = mid + 1;
                }
            } else {
                // nums = [6,7,0,1,2,4,5]
                // right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    // Example target = 4
                    // Check: 4 > 1 && 4 <= 5  => true
                    // So target is inside the sorted right half [2,4,5]. Discard [6,7,0,1]
                    left = mid + 1;
                } else {
                    // Example target = 7
                    // Check: 7 > 1 && 7 <= 5  => false
                    // So target is NOT inside the sorted right half. It must be in the left half.
                    // Keep [6,7,0] discard [1,2,4,5]
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}