class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int left = 0; left < nums.length - 3; left++) {
            if (left > 0 && nums[left] == nums[left - 1]) continue;

            for (int mid1 = left + 1; mid1 < nums.length - 2; mid1++) {
                if (mid1 > left + 1 && nums[mid1] == nums[mid1 - 1]) continue;

                twoSum(nums, left, mid1, target, result);
            }
        }

        return result;
    }

    // nums[left] + nums[mid1] + nums[mid2] + nums[right] == 0;
    // nums[mid2] + nums[right] = -nums[left] - nums[mid1]
    private void twoSum(int[] nums, int i, int j, int target, List<List<Integer>> result) {
        int left = j + 1;
        int right = nums.length - 1;
        long pairTarget = (long) target - nums[i] - nums[j];

        while (left < right) {
            long sum = (long) nums[left] + nums[right];

            if (sum < pairTarget) {
                left++;
            } else if (sum > pairTarget) {
                right--;
            } else {
                result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) left++;
                while (left < right && nums[right] == nums[right + 1]) right--;
            }
        }
    }
}