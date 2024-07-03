import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> sequence = new HashSet<>();
        int res = 0;
        for (int n : nums) sequence.add(n);
        for (int n : nums) {
            int next = n + 1;
            int prev = n - 1;
            int current = 1;
            while (sequence.remove(prev--)) current++;
            while (sequence.remove(next++)) current++;
            res = Math.max(res, current);
        }
        return res;
    }
}