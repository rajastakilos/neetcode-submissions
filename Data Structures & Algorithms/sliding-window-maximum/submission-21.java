class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        int resultIdx = 0;
        int windowSize = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // Expand
            maxHeap.offer(new int[]{nums[right], right});
            windowSize++;

            // Fix and Record
            while (windowSize == k) {
                int expired = right - k;
                while (maxHeap.peek()[1] <= expired) maxHeap.poll();
                result[resultIdx] = maxHeap.peek()[0];
                resultIdx++;
                windowSize--;
            }
        }

        return result;
    }
}
