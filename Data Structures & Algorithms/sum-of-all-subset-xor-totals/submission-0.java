class Solution {
    private int result = 0;
    public int subsetXORSum(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        backtrack(0, nums, subset);
        return this.result;
    }

    private void backtrack(int start, int[] nums, List<Integer> subset) {
        if (start == nums.length) return;

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);

            int xor = 0;
            for (int j = 0; j < subset.size(); j++) {
                xor = xor ^ subset.get(j);
            }
            this.result += xor;

            backtrack(i + 1, nums, subset);
            subset.remove(subset.size() - 1);
        }
    }
}