class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, target, candidates, result, path);
        return result;
    }

    private void dfs(int start, int remaining, int[] nums, List<List<Integer>> result, List<Integer> path) {
        if (remaining < 0) return;
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]){
                continue;
            } 
            path.add(nums[i]); // choose
            dfs(i + 1, remaining - nums[i], nums, result, path); // recurse
            path.remove(path.size() - 1); // backtrack
        }
    }
}
