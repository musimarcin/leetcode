//Given an array of meeting time interval objects consisting of
// start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i),
// find the minimum number of days required to schedule all meetings without any conflicts.

import java.util.List;
import java.util.PriorityQueue;

public class Problem253 {
    public class Interval {
    public int start, end;
    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
        }
    }
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 1) return 1;
        if (intervals.isEmpty()) return 0;
        intervals.sort((o1, o2) -> Integer.compare(o1.start, o2.start));
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (Interval interval : intervals) {
            //if previous interval ended before next one starts, remove from queue
            if (!queue.isEmpty() && queue.peek() <= interval.start) {
                queue.poll();
            }
            //add next interval to process
            queue.add(interval.end);
        }
        return queue.size();
    }
}
