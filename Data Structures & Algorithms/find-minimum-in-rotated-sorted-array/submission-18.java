class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) { // TODO
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) { // TODO
                left = mid + 1; //[5,6,7,8,1,2,3]
            } else {
                right = mid; // 4, 5, 1, 2, 3]. Toss out 4,5
            }
        }

        return nums[left];
    }
}
