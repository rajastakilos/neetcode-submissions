class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // Example sorted:
        // [[1,2], [1,3], [2,3], [3,4]]

        int result = 0;

        int[] current = intervals[0];
        // current = [1,2]

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // ---------------- OVERLAP CASE ----------------
            // Example:
            // current = [1,5], next = [2,3]
            // 5 > 2 → overlap → we must remove one
            if (current[1] > next[0]) {
                result++; // we remove one interval

                // Greedy: keep the one that ends earlier
                // Example:
                // current = [1,5], next = [2,3]
                // min(5,3) = 3 → keep [2,3] (smaller end)

                // Another example:
                // current = [1,3], next = [2,6]
                // min(3,6) = 3 → keep [1,3]

                current[1] = Math.min(current[1], next[1]);
            } 
            // ---------------- NO OVERLAP ----------------
            // Example:
            // current = [1,2], next = [2,3]
            // 2 > 2 ? no → no overlap → safe to move forward
            else {
                current = next;
            }
        }

        return result;
    }
}