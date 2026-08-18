class KthLargest {
    private PriorityQueue<Integer> minHeap; // kick out smallest number: root.
    private int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>(); // 
        this.k = k;
        buildMinHeap(nums);
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > this.k) minHeap.poll();
        return minHeap.peek();
    }

    private void buildMinHeap(int[] nums) {
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > this.k) minHeap.poll();
        }
    }
}
