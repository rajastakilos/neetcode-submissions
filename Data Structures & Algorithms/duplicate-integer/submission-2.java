class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int num : nums) {
            if (!integerSet.add(num)) return true;    
        } 

        return false;       
    }
    // Big O: 
    // Time: O(n) where n is the number of elements in the int array.
        // Worst case: The last two numbers in the array are the only duplicates. 
        // Best case: The first two number in the array are both duplicates.
    // Space: O(n) where n is the number of elements in the array. 
        // In the worst case we will store n - 1 in the Set. 
}