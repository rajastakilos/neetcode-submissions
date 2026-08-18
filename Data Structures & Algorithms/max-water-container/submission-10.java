class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int shorterHeights = Math.min(heights[left], heights[right]);
            int area = width * shorterHeights;
            maxArea = Math.max(maxArea, area);

            if (heights[left] < heights[right]) { // Greedy: Discard the shorter because we look for a taller wall than that. 
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
