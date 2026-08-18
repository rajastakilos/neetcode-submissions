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

        // end times of all meetings currently using rooms
        PriorityQueue<Integer> booked = new PriorityQueue<>();

        for (Interval meeting : intervals) {
            // If the new meeting starts after the earliest room (ends) becomes free, reuse that room.
            if (!booked.isEmpty() && 
                meeting.start >= booked.peek()) booked.poll(); // peek: earliest end time. 

            booked.offer(meeting.end); // Reuse room.
        }

        return booked.size();
    }
}
