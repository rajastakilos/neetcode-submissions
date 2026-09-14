class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            if (freq.containsKey(num)) {
                int currentVal = freq.get(num);
                currentVal++;
                freq.put(num, currentVal);
            } else {
                freq.put(num, 1);
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare (freq.get(a), freq.get(b))
        );

        for (int num : freq.keySet()) {
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
