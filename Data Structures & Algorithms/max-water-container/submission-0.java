class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int best = Integer.MIN_VALUE;; 
        while (left < right) {
            int currentAmount = (right - left) * Math.min(heights[left], heights[right]);
            best = Math.max(best, currentAmount);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }

        }

        return best;
    }
}
