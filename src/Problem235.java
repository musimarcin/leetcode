//Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
// two nodes p and q as the lowest node in T that has both p and q as descendants
// (where we allow a node to be a descendant of itself).”

public class Problem235 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return new TreeNode(0);
        TreeNode curr = root;
        while (curr != null) {
            if (p.val > curr.val && q.val > curr.val) curr = curr.right;
            else if (p.val < curr.val && q.val < curr.val) curr = curr.left;
            else return curr;
        }
        return curr;
    }
}
