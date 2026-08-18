class KthLargest {
    private final PriorityQueue<Integer> minHeap; // 1. PriorityQueue Class
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = populateMinHeap(nums);
    }
    
    public int add(int val) {
        this.minHeap.add(val); // 2. Crux: this line and next line. Add and poll if size greater than k.
        if (this.minHeap.size() > this.k) this.minHeap.poll(); // remove smallest number
        return this.minHeap.peek();
    }

    private PriorityQueue<Integer> populateMinHeap(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > this.k) minHeap.poll(); // remove smallest number.
        }

        return minHeap;
    }
}
