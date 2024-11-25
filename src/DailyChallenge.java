import java.util.*;

public class DailyChallenge {

    public int slidingPuzzle(int[][] board) {
        //board mapped to string for easier manipulation
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, Arrays.asList(1,3));
        map.put(1, Arrays.asList(0,2,4));
        map.put(2, Arrays.asList(1,5));
        map.put(3, Arrays.asList(0,4));
        map.put(4, Arrays.asList(1,3,5));
        map.put(5, Arrays.asList(2,4));
        //starting board
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int steps = 0;
        visited.add(start);
        q.offer(start);
        //BFS
        while (!q.isEmpty()) {
            //ensures to check all nodes on current level
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                String cur = q.poll();
                if (cur.equals("123450"))
                    return steps;
                //get location of 0
                int zero = cur.indexOf('0');
                //perform swap in every possible direction
                for (int n : map.get(zero)) {
                    StringBuilder next = new StringBuilder(cur);
                    char tmp = next.charAt(zero);
                    next.setCharAt(zero, next.charAt(n));
                    next.setCharAt(n, tmp);
                    String nextStr = next.toString();
                    //add to visited to avoid repetition
                    if (!visited.contains(nextStr)) {
                        visited.add(nextStr);
                        q.offer(nextStr);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

}
