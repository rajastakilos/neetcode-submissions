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
        if (intervals.size() == 0 || intervals.size() == 1) return true; // No overlap is possible.
        // 1. Sort by start time/
        intervals.sort(Comparator.comparing(obj -> obj.start));
        
        // 2. use prevEnd from first interval. 
        int prevEnd = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            int curStart = intervals.get(i).start;
            int curEnd = intervals.get(i).end;
            if (curStart < prevEnd) return false;
            
                prevEnd = curEnd;
            
        }

        return true;
    }
}
