class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1]; // n + 1 because we must account for 0's bit count.
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.bitCount(i);
        }
    
        return ans;
    }

}
// Time: O(n * log n)
// Space: O(n): New answer array of length n + 1;

// TODORAJAS: DP version of this.