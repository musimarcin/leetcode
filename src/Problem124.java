//A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge
// connecting them. A node can only appear in the sequence at most once. Note that the path does not need
// to pass through the root.
//
//The path sum of a path is the sum of the node's values in the path.
//
//Given the root of a binary tree, return the maximum path sum of any non-empty path.

public class Problem124 {
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
    public int maxPathSum(TreeNode root) {
        int[] result = {root.val};
        helperMaxPathSum(root, result);
        return result[0];
    }

    private int helperMaxPathSum(TreeNode root, int[] result) {
        if (root == null) return 0;
        // calculate maximum value of the left and right subtree
        int leftTree = helperMaxPathSum(root.left, result);
        int rightTree = helperMaxPathSum(root.right, result);
        leftTree = Math.max(leftTree, 0);
        rightTree = Math.max(rightTree, 0);

        //update global list with result
        result[0] = Math.max(result[0], root.val + leftTree + rightTree);

        //return value with higher value and value of the current root
        return root.val + Math.max(leftTree, rightTree);
    }
}
