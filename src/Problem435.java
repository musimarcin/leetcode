//Given an array of intervals intervals where intervals[i] = [starti, endi],
// return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

import java.util.Arrays;

public class Problem435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prevEnd = intervals[0][1];
        System.out.println(Arrays.deepToString(intervals));
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            //if previous interval ends earlier than current starts e.g. [[1,2] [3,4]] means
            // that they are not overlapping and need to move end point
            if (start >= prevEnd) prevEnd = end;
            //if they're overlapping, add one interval to remove
            // and calculate new previous end to avoid future overlapping
            else {
                result += 1;
                prevEnd = Math.min(prevEnd, end);
            }
        }
        return result;
    }
}
