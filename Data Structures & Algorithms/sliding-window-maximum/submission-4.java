class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int kCount = 0;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );
        int resIndex = 0;

        for (int right = 0; right < nums.length; right++) {
            // Expand
            kCount++;
            maxHeap.offer(new int[]{nums[right], right});

            // Record and Fix
            if (right >= k - 1) {
                while (maxHeap.peek()[1] <= right - k) maxHeap.poll();
                result[resIndex++] = maxHeap.peek()[0];
            }
        }

        return result;
    }
}