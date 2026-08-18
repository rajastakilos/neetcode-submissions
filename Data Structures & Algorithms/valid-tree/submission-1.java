class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) return false; // A tree must have exactly n - 1 edges. Necessary condition.

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) { // 1. Build Undirected graph. 2 way connection. List of pairs
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, -1}); // 0 is arbitrary. -1 is a dummy value since root node has no parent.
        visit.add(0); // The moment we add the node we mark it visited. 

        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int node = pair[0];
            int parent = pair[1];

            for (int nei : adj.get(node)) { // List of neighbors.
                if (nei == parent) continue; // Ignore the edge we came from.
                if (visit.contains(nei)) return false; // If neighbor is visited AND it's NOT your parent. 

                visit.add(nei);
                q.offer(new int[]{nei, node}); // So a BFS right? 
            } 
        }

        return visit.size() == n; // If you didn’t visit all nodes → disconnected → not a tree
    }
}

// A graph is a valid tree if:
//     It has no cycles
//     It is fully connected