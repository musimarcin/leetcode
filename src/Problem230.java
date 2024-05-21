//Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed)
// of all the values of the nodes in the tree.

import java.util.ArrayList;
import java.util.Stack;

public class Problem230 {
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int result = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k -= 1;
            if (k == 0) {
                result = curr.val;
                return result;
            }
            curr = curr.right;
        }
        return result;
    }
}
