class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        int kCount = 0;

        for (int right = 0; right < nums.length; right++) {
            // Expand
            maxHeap.offer(new int[]{nums[right], right});
            kCount++;

            // Fix and Record
            if (kCount == k) {
                int expired = right - k; // Key: right - k. 
                while (maxHeap.peek()[1] <= expired) maxHeap.poll(); // Key <=
                result[resultIndex++] = (maxHeap.peek()[0]);
                kCount--;
            }
        }

        return result;
    }
}
