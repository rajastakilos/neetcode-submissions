class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        dfs(nums, used, result, path);
        return result;
    }

    private void dfs(int[] nums, boolean[] used, List<List<Integer>> result, List<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            path.add(nums[i]); // choose
            used[i] = true;

            dfs(nums, used, result, path); // recurse

            path.remove(path.size() - 1); // backtrack
            used[i] = false;
        }
    }
}
