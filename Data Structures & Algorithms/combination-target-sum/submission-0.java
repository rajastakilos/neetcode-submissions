class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(0, target, nums, result, path);
        return result;
    }

    private void dfs(int start, int remaining, int[] nums, List<List<Integer>> result, List<Integer> path) {
        if (remaining < 0) return;
        if (remaining == 0) { 
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]); // choose
            dfs(i, remaining - nums[i], nums, result, path); // recurse
            path.remove(path.size() - 1); // backtrack
        }
    }
}
