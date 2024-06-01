//Given a reference of a node in a connected undirected graph.
//
//Return a deep copy (clone) of the graph.
//
//Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
//Test case format:
//
//For simplicity, each node's value is the same as the node's index (1-indexed). For example,
// the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
//
//An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
//
//The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> result = new HashMap<>();
        return helper(node, result);
    }

    private Node helper(Node node, HashMap<Node, Node> result) {
        //if theres a copy of a node already then return that copy
        if (result.containsKey(node)) return result.get(node);
        if (node == null) return null;
        //create a copy node with its value
        Node copy = new Node(node.val);
        //add a copy to a hashmap maping it to its original
        result.put(node, copy);
        //add every neighbors for copy from original node recursively
        for (int i = 0; i < node.neighbors.size(); i++) {
            copy.neighbors.add(helper(node.neighbors.get(i), result));
        }
        //return copied node
        return copy;
    }
}
