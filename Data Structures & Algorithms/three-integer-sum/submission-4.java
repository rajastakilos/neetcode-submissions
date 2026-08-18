class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // Big O?

        for (int left = 0; left < nums.length - 2; left++) { // ! stop 2 short of the end. 
            if (left > 0 && nums[left] == nums[left - 1]) continue;
            
            int mid = left + 1; // Move mid with left when skipping
            int right = nums.length - 1;

            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum < 0) {
                    mid++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    
                    // skip dupes
                    while (mid < right && nums[mid] == nums[mid + 1]) mid++;
                    while (mid < right && nums[right] == nums[right - 1]) right--;

                    mid++;
                    right--;
                }
            }       
        }

        return result;
    }
}
