class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] > nums[right]) { // 3 4 5 [6] 7 1 [2]
                if (target >= nums[left] && target < nums[mid]) { // [3] 4* 5 [6] 7 1 2 -> 3 4* 5
                    right = mid - 1;
                } else { // 3 4 5 [6] 7 1* 2 -> 6 7 1* 2
                    left = mid + 1;
                }
            } else { // 7 1 2 [3] 4 5 [6] 
                if (target > nums[mid] && target <= nums[right]) { // 7 1 2 [3] 4* 5 [6] 
                    left = mid + 1;
                } else { // 7 1* 2 [3] 4 5 [6] 
                    right = mid - 1; 
                }
            }
        }

        return -1;
    }
}
