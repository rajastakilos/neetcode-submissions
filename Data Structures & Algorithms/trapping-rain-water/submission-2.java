class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int result = 0;

        while (left < right) {
            if (leftMax < rightMax) { // Side that is limiting factor
                leftMax = Math.max(leftMax, height[++left]);
                result += leftMax - height[left];
            } else {
                rightMax = Math.max(rightMax, height[--right]);
                result += rightMax - height[right];
            }
        }

        return result;
    }
}
