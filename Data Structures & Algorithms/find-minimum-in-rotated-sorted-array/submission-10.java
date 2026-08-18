class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
                                            //.       M     R
            if (nums[mid] > nums[right]) { // [4,5,6,7,0,1,2]
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left]; // The minimum is always inside the range [left, right]
        // At the end the search space collapses to one element: left. 
    }
}
// The minimum is always in the unsorted half. 
// If mid > right we crossed the rotation pivot. 
