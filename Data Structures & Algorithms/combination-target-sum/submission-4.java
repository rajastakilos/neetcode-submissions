class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(0, target, nums, path, result);
        return result;
    }

    private void backtrack(int start, int target, int[] nums, List<Integer> path, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            // Key: For same number to be chosen ONLY once use i + 1;
            backtrack(i, target - nums[i], nums, path, result);
            path.remove(path.size() - 1);
        }
    }
}
