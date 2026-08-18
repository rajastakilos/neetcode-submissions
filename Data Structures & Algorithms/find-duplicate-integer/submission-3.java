class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int duplicate = 0;
        for (int num : nums) {
            if (!seen.add(num)) { 
                duplicate = num;
                break;
            }
        }

        return duplicate;
    }
}
