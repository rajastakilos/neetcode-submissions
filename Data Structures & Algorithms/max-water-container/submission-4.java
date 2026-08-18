class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int best = 0;

        while (left < right) {
            int width = right - left;
            int shorterWall = Math.min(heights[left], heights[right]);
            int area = width * shorterWall;

            best = Math.max(best, area);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return best;
    }
}
