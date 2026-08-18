class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // n * log n.
        int result = 0;

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (current[1] > next[0]) {
                current[1] = Math.min(current[1], next[1]);
                result++;
            } else {
                current = next;
            }

        }

        return result;
    }
}
