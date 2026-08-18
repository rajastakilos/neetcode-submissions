class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int left = 0; left < nums.length - 2; left++) {
            int mid = left + 1;
            int right = nums.length - 1;
            if (left > 0 && nums[left] == nums[left - 1]) continue;

            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    mid++;
                    right--;
                    while (mid < right && nums[mid] == nums[mid - 1]) mid++;
                    while (mid < right && nums[right] == nums[right + 1]) right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }

        return result;
    }
}
