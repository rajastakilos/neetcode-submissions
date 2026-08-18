class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) { // Note
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) { // Note
                right = mid - 1;
            } else if (nums[mid] < target) { // Note
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
