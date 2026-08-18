class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) { // less than or equal          
            int mid = left + (right - left) / 2; // Define mid as we go.
            if (target > nums[mid]) left = mid + 1;
            if (target < nums[mid]) right = mid - 1;
            if (target == nums[mid]) return mid;
            //     return mid;
            // }      
        }

        return -1;
    }
}
