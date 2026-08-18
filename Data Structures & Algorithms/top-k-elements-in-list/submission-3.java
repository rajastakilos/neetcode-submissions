class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Build a map
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Find top k frequent with minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> count.get(a) - count.get(b)
        );

        // Get top k
        for (int num: count.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
