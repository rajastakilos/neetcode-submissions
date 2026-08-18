class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums); 
        backtrack(0, nums, subset, result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) continue;
            subset.add(nums[i]);
            backtrack(i + 1, nums, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
