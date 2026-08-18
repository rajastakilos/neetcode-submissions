/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0 || intervals == null) return true;
        Collections.sort(intervals, 
            (Interval a, Interval b) -> 
                Integer.compare(a.start, b.start)); // O (n * log n);

        Interval current = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            if (current.end > intervals.get(i).start) return false;
            current = intervals.get(i);
        }

        return true;
    }
}
