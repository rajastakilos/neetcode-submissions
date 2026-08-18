class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (int[] a, int[] b) -> Integer.compare(
                    b[0] * b[0] + b[1] * b[1],
                    a[0] * a[0] + a[1] * a[1]
            )
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;

    }
}

// Start with sqrt( (x1 - x2)^2 + (y1 - y2)^2 )
// One point is always zero: sqrt( (x1 - 0)^2 + (y1 - 0)^2 )
// Now remove the sqrt root because we don't need the exact distance. It doesn't remove ordering.
// We are left with (x1 * x1)^2 + (y1 * y1)^2 for each point.
