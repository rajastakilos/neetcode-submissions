class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int shorterWall = Math.min(heights[left], heights[right]); // Shorter wall is what limits the water.
            int area = width * shorterWall;
            maxArea = Math.max(maxArea, area);

            if (heights[left] < heights[right]) { // Greedy: “We want a wide pair where the shorter wall is as tall as possible” 
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
