class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] pre : prerequisites) { // 1. Build adjList of prequesites to courses they unlock.
            inDegree[pre[0]]++; // This course has a prerequisite
            adj.get(pre[1]).add(pre[0]); // Prereq → course it unlocks
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.add(i); // This course has no prerequisites to begin with. Start of Kahn's. 
        }

        int finish = 0;
        while (!q.isEmpty()) {
            int node = q.poll(); // Take a course that is now available
            finish++; // We have successfully taken one more course

            for (int n : adj.get(node)) { // all courses that depend on node. 
                inDegree[n]--; // We completed node, which was one of n’s prereqs
                if (inDegree[n] == 0) q.add(n); // All prereqs satisfied. 
            }
        }

        return finish == numCourses;
    }
}
