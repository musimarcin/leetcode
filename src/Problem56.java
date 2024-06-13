//Given an array of intervals where intervals[i] = [starti, endi],
// merge all overlapping intervals, and return an array of the non-overlapping intervals
// that cover all the intervals in the input.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem56 {
    public int[][] merge(int[][] intervals) {
        //sort intervals by first element of each subarray
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            int lastEnd = list.get(list.size() - 1)[1];

            //because list is sorted current start can be compared with last element of that list
            //if its smaller then replace last's element ending interval with whichever is bigger
            if (currStart <= lastEnd) list.get(list.size() - 1)[1] = Math.max(lastEnd, currEnd);
            else list.add(new int[]{currStart, currEnd});
        }

        //move list to int[][] array
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
}
