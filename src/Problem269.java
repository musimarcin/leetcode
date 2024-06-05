//There is a foreign language language which uses the latin alphabet,
// but the order among letters is not "a", "b", "c" ... "z" as in English.
//
//You receive a list of non-empty strings words from the dictionary,
// where the words are sorted lexicographically based on the rules of this new language.
//
//Derive the order of letters in this language. If the order is invalid,
// return an empty string. If there are multiple valid order of letters, return any of them.
//
//A string a is lexicographically smaller than a string b if either of the following is true:
//
//The first letter where they differ is smaller in a than in b.
//There is no index i such that a[i] != b[i] and a.length < b.length.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem269 {
    public String foreignDictionary(String[] words) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> visited = new HashMap<>(); // -1 for visited, 1 for processed
        StringBuilder result = new StringBuilder();

        // create a graph with every character from words
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                visited.put(c, 0);
            }
        }

        // add connections for a graph
        for (int i = 0; i < words.length - 1; i++) {
            //checking current word and next one, calculating minimum length
            String first = words[i];
            String second = words[i + 1];
            int minLen = Math.min(first.length(), second.length());
            // if first word is shorter or its prefix is different it means that there's no correct result(invalid order)
            if (first.length() > second.length() && first.substring(0, minLen).equals(second.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                // checking character by character if they differ
                char one = first.charAt(j);
                char two = second.charAt(j);
                if (one != two) {
                    //connecting characters
                    graph.get(one).add(two);
                    break;
                }
            }
        }

        // run dfs for created graph
        for (char c : graph.keySet()) {
            if (visited.get(c) == 0) {
                if (!helper(graph, visited, result, c)) {
                    return "";
                }
            }
        }

        return result.reverse().toString();
    }

    private boolean helper(HashMap<Character, List<Character>> graph, HashMap<Character, Integer> visited,
                           StringBuilder result, char curr) {

        // -1 means that theres a cycle and 1 it already has been processed
        if (visited.get(curr) == -1)  return false;
        if (visited.get(curr) == 1) return true;

        // add to path (visiting)
        visited.put(curr, -1);

        //going for neighbours of current character
        for (char c : graph.get(curr)) {
            if (!helper(graph, visited, result, c)) return false;
        }

        // mark character as processed
        visited.put(curr, 1);
        result.append(curr);
        return true;
    }
}