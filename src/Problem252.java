//Given an array of meeting time interval objects consisting of
// start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i),
// determine if a person could add all meetings to their schedule without any conflicts.

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem252 {
      public class Interval {
      public int start, end;
      public Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
    }
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) return true;
        intervals.sort((o1, o2) -> Integer.compare(o1.start, o2.start));
        int prevEnd = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            if (start < prevEnd) return false;
            else prevEnd = end;
        }
        return true;
    }
}
