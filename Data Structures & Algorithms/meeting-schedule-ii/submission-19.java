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
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Integer> booked = new PriorityQueue<>();

        for (Interval meeting : intervals) {
            if (!booked.isEmpty() &&
                meeting.start >= booked.peek()) booked.poll();
            
            booked.offer(meeting.end);
        }

        return booked.size();
    }
}
