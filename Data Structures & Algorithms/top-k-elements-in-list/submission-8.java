class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        // num to frequency map
        for (int num : nums) {
            counts.put(num , counts.getOrDefault(num, 0) + 1);
        }

        // minHeap with a comparator.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> counts.get(a) - counts.get(b)
        );

        // Compare top k values. PQ contains keys
        for (int num : counts.keySet()) {
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
