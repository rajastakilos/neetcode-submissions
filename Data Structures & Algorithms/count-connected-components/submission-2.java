class Solution {
    public int countComponents(int n, int[][] edges) {
        // 0. Adj list and visit boolean array.
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visit = new boolean[n];
        // 1. Empty adj list
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        // 2. Build undirected graph as adjacency list.
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Start DFS → explore the entire component
        // Increment res → we just discovered one full component
        int res = 0;
        for (int node = 0; node < n; node++) {
            if (!visit[node]) {
                dfs(adj, visit, node);
                res++;
            }
        }

        return res;
    }

    private void dfs(List<List<Integer>> adj, boolean[] visit, int node) {
        visit[node] = true;
        for (int nei : adj.get(node)) {
            if (!visit[nei]) dfs(adj, visit, nei);
        }
    }
}
