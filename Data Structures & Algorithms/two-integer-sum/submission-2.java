class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> prevNumToIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int desiredNumber = target - nums[i];
            if (prevNumToIndexMap.containsKey(desiredNumber)) {
                int desiredIndex = prevNumToIndexMap.get(desiredNumber);
                return new int[]{desiredIndex, i};
            }
            
            prevNumToIndexMap.put(nums[i], i);    
        } 

        throw new IllegalArgumentException("No valid two sum solution");
    }
}
