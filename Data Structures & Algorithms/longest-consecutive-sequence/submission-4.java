class Solution {
    public int longestConsecutive(int[] nums) {
        int longestSequence = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        for (Integer element : set) {
            int currentLongest = 1;
            if (!set.contains(element - 1)) {
                while (set.contains(element + 1)) {
                    currentLongest++;
                    element++;
                }
                longestSequence = Math.max(currentLongest, longestSequence);                
            }

        }

        return longestSequence;
    }
}
// Time: O(n ^ 2): TODORAJAS: Clarify why this is actually O(n).
// Space: O(n). Made a hash set that contains all unique values from the input array.