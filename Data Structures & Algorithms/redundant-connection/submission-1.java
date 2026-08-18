class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int [] parent = new int[edges.length + 1];
        int [] rank = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; // I am my own component.
            rank[i] = 1; // Size of each component is one.
        }

        for (int[] edge: edges) {
            if (!union(parent, rank, edge[0], edge[1])) {
                return new int[]{ edge[0], edge[1] };
            }
        }

        return new int[0];
    }

    private boolean union(int[] parent, int[] rank, int n1, int n2) {
        int p1 = find(parent, n1);
        int p2 = find(parent, n2);

        if (p1 == p2) return false; // Both have same root. Adding it creates a cycle. 

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        return true;
    }

    private int find(int[] parent, int n) { // return root of component n belongs to. 
        int p = parent[n]; // n's parent.
        while (p != parent[p]) { //keep going until we reach the root. Root: p == parent[p]
            parent[p] = parent[parent[p]]; // path compression. Point nodes to grandparent. Makes future find faster. 
            p = parent[p]; // Move up the tree. 
        }

        return p; // return root of the component. 
        // p is a pointer that moves up the tree. n is the original node.
    }
}
