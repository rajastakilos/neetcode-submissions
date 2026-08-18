class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(used, nums, subset, result);
        return result;
    }

    private void backtrack(boolean[] used, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        if (subset.size() > nums.length) return;
        if (subset.size() == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            subset.add(nums[i]);
            used[i] = true;

            backtrack(used, nums, subset, result);

            subset.remove(subset.size() - 1);
            used[i] = false;
        }
    }
}