class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> b - a
        );
        int resultIdx = 0;
        int windowSize = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // Expand
            maxHeap.offer(nums[right]);
            windowSize++;

            // Fix
            while (windowSize > k) {
                maxHeap.remove(nums[left++]);
                windowSize--;
            }
            
            // Record
            if (windowSize == k) {
                result[resultIdx++] = maxHeap.peek();
            }
        }

        return result;
    }
}
