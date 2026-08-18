class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> differenceMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (differenceMap.containsKey(difference)) {
                int desiredIndex = differenceMap.get(difference);
                return new int[]{desiredIndex, i};
            } else {
                differenceMap.put(nums[i], i);    
            }
        } 

        return null;
    }
}
