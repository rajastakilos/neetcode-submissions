class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFrequencyCountMap = new HashMap<>();
        for (int num : nums) {
            int count = numToFrequencyCountMap.getOrDefault(num, 0);
            numToFrequencyCountMap.put(num, count + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1]; // Array of lists. int[].
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        numToFrequencyCountMap.forEach((key, value) -> {
            buckets[value].add(key);
        });

        int kCount = k - 1;
        int[] result = new int[k];
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i].size() != 0) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    if (kCount >= 0) {
                        result[kCount] = buckets[i].get(j);
                        kCount--;
                    }
                }
            }
        }

        return result;
    }
}
