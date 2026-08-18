class Solution {
    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        for (int left = 0; left < nums.length; left++) {
            if (left > 0 && nums[left] == nums [left - 1]) continue;
            int mid = left + 1;
            int right = nums.length - 1;
            twoSum(left, mid, right, nums);
        }

        return this.result;
    }

    // nums[i] + nums[j] + nums[k] == 0
    // nums[j] + nums[k] == -nums[i]
    private void twoSum(int left, int mid, int right, int[] nums) {
        int target = -1 * nums[left];
        while (mid < right) {
            if (nums[mid] + nums[right] > target) {
                right--;
            } else if (nums[mid] + nums[right] < target) {
                mid++;
            } else {
                this.result.add(
                    Arrays.asList(nums[left], nums[mid], nums[right]));
                while (mid < right && nums[mid] == nums[mid + 1]) mid++;
                while (mid < right && nums[right] == nums[right - 1]) right--;
                mid++;
                right--;
            }
        }
    }
}
// 4, -3, -1
// -3, -1 = -4
