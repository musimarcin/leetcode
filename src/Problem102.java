//Given the root of a binary tree, return the level order traversal of its nodes' values.
// (i.e., from left to right, level by level).

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem102 {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<TreeNode> queue = new PriorityQueue<>();
        if (root == null) return result;
        else result.add(Arrays.asList(root.val));
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                integerList.add(queue.remove().val);
            }
            result.add(integerList);
        }
        return result;
    }
}
