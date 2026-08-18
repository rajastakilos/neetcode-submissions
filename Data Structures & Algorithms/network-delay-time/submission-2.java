class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build Adj list.
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] t : times) { // [from, to, weight]
            graph.computeIfAbsent(t[0], x -> new ArrayList<>()) // source
                .add(new int[]{t[1], t[2]}); // target and time.
        }

        // 2. minHeap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>( // the node with the smallest current known arrival time
            (a, b) -> Integer.compare(a[0], b[0]) // Good idea to use Integer.compare
        );
        minHeap.offer(new int[]{0, k}); // [timeToReachThisNode, node]
        // it takes 0 time to reach the starting node k because we start at k.

        Set<Integer> visited = new HashSet<>(); // we have finalized the shortest time to this node
        // In Dijkstra, the first time we pop a node from the min-heap, 
        // that time is guaranteed to be the shortest possible time to THAT node.
        int maxTime = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int time = curr[0]; // 
            int node = curr[1];

            if (visited.contains(node)) continue; // We already got the shortest time for this node.
            // Ex. Node 3 is reachable in time 2. If we see 3 later, this is useless. 2 is optimal. 
            // [2, 3]
            // [5, 3]
            visited.add(node);
            maxTime = time; // Nodes pop in non-decreasing time. The last finalized time is automatically the maximum one

            if (!graph.containsKey(node)) continue; // Because some nodes may have no outgoing edges.

            for (int[] next : graph.get(node)) {
                if (!visited.contains(next[0])) {
                    // “Here is one possible way to reach this neighbor.”
                    // We do not yet know if it is the best path. That is why it goes into the heap.
                    // The heap will sort all candidate paths, and the best one will come out first.
                    minHeap.offer(new int[]{ time + next[1], next[0]});
                }
            }
        }

        return visited.size() == n ? maxTime : -1;
        
    }
}
// Classic Dijkstra:

// Initialize distances
// Use min-heap to always pick closest node
// Relax edges
// Finalize node once popped
