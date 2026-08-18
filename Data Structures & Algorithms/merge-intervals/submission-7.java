class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        
        int[] current = intervals[0];
        result.add(current);

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // Example: current = [1,6], next = [8,10]
            // next.start > current.end → no overlap → start new interval
            if (current[1] < next[0]) { // no overlap
                current = next;
                result.add(current);
            } 
            // Example: current = [1,3], next = [2,6]
            // next.start <= current.end → overlap → merge → [1,6]
            else { // next[0] <= current[1]
                current[1] = Math.max(current[1], next[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
