class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Build: Num to Frequency Map
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // MinHeap that stores num by comparator checks frequencies.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> count.get(a) - count.get(b)
        );

        // Get top k by comparing values.
        for (int num : count.keySet()) {
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
