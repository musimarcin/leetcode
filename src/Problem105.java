//Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and
// inorder is the inorder traversal of the same tree, construct and return the binary tree.

import java.util.Arrays;
import java.util.HashMap;

public class Problem105 {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //put inorder to hashmap for fast access
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return helperBuildTree(hashMap, preorder, 0, 0, inorder.length - 1);
    }

    private TreeNode helperBuildTree(HashMap<Integer, Integer> hashMap, int[] pre, int pre_index, int in_left, int in_right) {
        //get root value from preorder
        int root_val = pre[pre_index];
        //find root in inorder
        int in_mid = hashMap.get(root_val);
        TreeNode root = new TreeNode(root_val);

        //move by 1 index from preorder to next root target with length from left of the inorder found root index to index of found root
        if (in_mid > in_left) root.left = helperBuildTree(hashMap, pre, pre_index + 1, in_left, in_mid - 1);
        //if there are no more subtrees (from left of the inorder found root) move preorder index to the end of left subtree length
        if (in_mid < in_right) {
            int left_len = pre_index + in_mid - in_left + 1;
            root.right = helperBuildTree(hashMap, pre, left_len, in_mid + 1, in_right);
        }
        return root;
    }
}
