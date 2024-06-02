//There is an undirected graph with n nodes. There is also an edges array, where edges[i] = [a, b]
// means that there is an edge between node a and node b in the graph.
//
//Return the total number of connected components in that graph.

import java.util.*;

public class Problem323 {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> parents = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int result = 0;

        //if theres no connections between nodes, add amount of nodes to result
        if (edges.length == 0) result += n;

        for (int[] e : edges) {
            if (!parents.containsKey(e[0])) parents.put(e[0], new ArrayList<>());
            if (!parents.containsKey(e[1])) parents.put(e[1], new ArrayList<>());
            parents.get(e[1]).add(e[0]);
            parents.get(e[0]).add(e[1]);
        }
        //dfs through every element in tree and every new element means new connection
        for (int i : parents.keySet()) {
            if (!visited.contains(i)) {
                helper(i, visited, parents);
                result += 1;
            }
        }
        return result;
    }

    private void helper(int i, Set<Integer> visited, HashMap<Integer, List<Integer>> parents) {
        visited.add(i);
        for (int j : parents.get(i)) {
             if (!visited.contains(j)) helper(j, visited, parents);
        }
    }
}
