//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
// course bi first if you want to take course ai.
//
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.

import java.util.*;

public class Problem207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preq = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int[] pre : prerequisites) {
            //adding every element to a course
            if (!preq.containsKey(pre[0])) preq.put(pre[0], new ArrayList<>());
            if (!preq.containsKey(pre[1])) preq.put(pre[1], new ArrayList<>());
            //adding every connection to given course
            preq.get(pre[0]).add(pre[1]);
        }
        //loop through courses in hashmap
        for (Map.Entry<Integer, List<Integer>> entry : preq.entrySet()) {
            int i = entry.getKey();
            if (!helper(i, visited, preq)) return false;
        }
        return true;
    }

    private boolean helper(int i, Set<Integer> visited, HashMap<Integer, List<Integer>> preq) {
        //if preq is empty theres no prerequisites
        if (preq.isEmpty()) return false;
        if (preq.get(i).isEmpty()) return true;
        //if a course has been visited it means there's a loop in graph
        if (!visited.add(i)) return false;
        //looping through every connection of given course
        for (int j : preq.get(i)) {
            if (!helper(j, visited, preq)) return false;
        }
        visited.remove(i);
        preq.put(i, new ArrayList<>());
        return true;
    }
}
