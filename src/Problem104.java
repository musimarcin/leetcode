//Given the root of a binary tree, return its maximum depth.
//
//A binary tree's maximum depth is the number of nodes along the longest path from the root node down to
// the farthest leaf node.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem104 {
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
  }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int counter = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode curr = queue.remove();
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            counter += 1;
        }
        return counter;
    }
//not working
    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int counter = 0;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            int depth = 0;
            if (curr != null) {
                counter = Math.max(counter, depth);
                stack.push(curr.left);
                depth =+ 1;
                stack.push(curr.right);
                depth =+ 1;
            }
        }
        return counter;
    }
}
