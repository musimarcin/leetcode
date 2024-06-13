//You are given an array of non-overlapping intervals intervals where
// intervals[i] = [starti, endi] represent the start and the end of the ith interval and
// intervals is sorted in ascending order by starti. You are also given an interval
// newInterval = [start, end] that represents the start and end of another interval.
//
//Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
// still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//Return intervals after the insertion.
//
//Note that you don't need to modify intervals in-place. You can make a new array and return it.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        for (int[] interval : intervals) {
            int currStart = interval[0];
            int currEnd = interval[1];
            //add current interval to list if new interval is later
            if (newStart > currEnd) list.add(new int[]{currStart, currEnd});
            //case if new interval is before current one
            else if (newEnd < currStart) {
                list.add(new int[]{newStart, newEnd});
                //change new intervals to current because they're not gonna be used anymore
                newStart = currStart;
                newEnd = currEnd;
            //calculate overlapping intervals
            } else {
                newStart = Math.min(newStart, currStart);
                newEnd = Math.max(newEnd, currEnd);
            }
        }
        list.add(new int[]{newStart, newEnd});
        //move list to int[][] array
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;

//        List<int[]> result = new ArrayList<>();
//        int i = 0;
//        int len = intervals.length;
//
//        int newStart = newInterval[0];
//        int newEnd = newInterval[1];
//        int start = intervals[i][0];
//        int end = intervals[i][1];
//
//        while (i < len && intervals[i][1] < newInterval[0]) {
//            result.add(intervals[i]);
//            i += 1;
//        }
//
//        while (i < len && intervals[i][0] <= newInterval[1]) {
//            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
//            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
//            i += 1;
//        }
//        result.add(newInterval);
//
//        while (i < len) {
//            result.add(intervals[i]);
//            i += 1;
//        }
//
//        return result.toArray(new int[result.size()][]);
    }
}
