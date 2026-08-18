class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();

            for (int j = 0; j < size; j++) {
                List<Integer> original = result.get(j);
                List<Integer> clone = new ArrayList<>(original);
                clone.add(nums[i]);
                result.add(clone);
            }
        }

        return result;
    }
}
