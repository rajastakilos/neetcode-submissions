class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 1. Sort array
        Arrays.sort(nums);

        // 2. Result
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) { // Note: stop 2 short of end.
            // 3. skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // First pointer: i.
            int left = i + 1; // Second pointer left (i + 1)
            int right = nums.length - 1; // Last pointer (end of array)

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }

                
            }
        }

        return result;
    }
}
