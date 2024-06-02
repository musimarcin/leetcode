//Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
// write a function to check whether these edges make up a valid tree.

import java.util.*;

public class Problem261 {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> parents = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        if (n == 1) return edges.length == 0;
        if (edges.length == 0) return false;

        for (int[] e : edges) {
            if (!parents.containsKey(e[0])) parents.put(e[0], new ArrayList<>());
            if (!parents.containsKey(e[1])) parents.put(e[1], new ArrayList<>());
            parents.get(e[1]).add(e[0]);
            parents.get(e[0]).add(e[1]);
        }
        //if every node has been visited, hashset should be same size as n
        if (!helper(0, -1, visited, parents)) return false;
        return n == visited.size();
    }

    private boolean helper(int i, int prev, Set<Integer> visited,  HashMap<Integer, List<Integer>> parents) {
        //base cases
        if (parents.isEmpty()) return false;
        if (parents.get(i).isEmpty()) return true;
        // checking for loop in tree
        if (visited.contains(i)) return false;
        visited.add(i);
        for (int j : parents.get(i)) {
            // if its previous node then continue loop
            if (j == prev) continue;
            if (!helper(j, i, visited, parents)) return false;
        }
        return true;
    }
}
