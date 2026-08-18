class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (int[] a, int[] b) ->
                Integer.compare(
                    b[0]*b[0] + b[1]*b[1],
                    a[0]*a[0] + a[1]*a[1]
                )
        );

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        int[][] result = new int[maxHeap.size()][2]; // Dimensions: how many arrays, what size.
        int i = 0;
        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll();
        }

        return result;
    }
}

// Time: O(n * log k) for populating heap. Insertion into heap is O(n).
// Space: O(k). Heap store at most k + 1 points in the array at any given time. Result stores k.
// maxHeap: I need to store the furthest point as the root. Think 4, 6, 20, 2
    // After processing first three my maxHeap is 20 (root), 4 (left), 6 (right)
    // Adding 2 means we pop the root and then add 2. We end up with: 6 (root), 4 (right), 2 (left).