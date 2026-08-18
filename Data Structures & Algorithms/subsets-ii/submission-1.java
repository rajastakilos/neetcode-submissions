class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        int lastSize = 0;

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            int start = 0;

            if (i > 0 && nums[i] == nums[i - 1]) start = lastSize;

            for (int j = start; j < size; j++) {
                List<Integer> clone = new ArrayList<>(result.get(j));
                clone.add(nums[i]);
                result.add(clone);
            }

            lastSize = size; // next iterations duplicate starts here.
        }
        
        return result;
    }
}
