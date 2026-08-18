class KthLargest {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = populateMinHeap(nums);    
    }
    
    public int add(int val) {
        this.minHeap.add(val);
        if (minHeap.size() > this.k ) this.minHeap.poll();
        return minHeap.peek();
    }

    private PriorityQueue<Integer> populateMinHeap (int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > this.k) minHeap.poll();                
        }

        return minHeap;
    }
}
