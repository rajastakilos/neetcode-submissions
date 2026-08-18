class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int left = 0; left < nums.length - 3; left++) {
            if (left > 0 && nums[left] == nums[left - 1]) continue;

            for (int mid1 = left + 1; mid1 < nums.length - 2; mid1++) {
                if (mid1 > left + 1 && nums[mid1] == nums[mid1 - 1]) continue;

                int mid2 = mid1 + 1;
                int right = nums.length - 1;
                while (mid2 < right) {
                    long sum = (long) nums[left] + nums[mid1] + nums[mid2] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[left], nums[mid1], nums[mid2], nums[right]));
    
                        while (mid2 < right && nums[mid2] == nums[mid2 + 1]) mid2++;
                        while (mid2 < right && nums[right] == nums[right - 1]) right--;
                                            mid2++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        mid2++;
                    }
                }
            }
        }

        return result;
    }
}