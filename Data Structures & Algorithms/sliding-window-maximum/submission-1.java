class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int kCount = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> b - a
        );

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // Expand
            kCount++;
            maxHeap.offer(nums[right]);

            // Record and Fix
            if (kCount == k) {
                result.add(maxHeap.peek());   // Add largest number in window.
                maxHeap.remove(nums[left++]); // Remove leftmost number. 
                kCount--;
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}