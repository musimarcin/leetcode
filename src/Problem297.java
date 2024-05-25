//Serialization is the process of converting a data structure or object into a sequence of bits
// so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be
// reconstructed later in the same or another computer environment.
//
//Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
// serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
// to a string and this string can be deserialized to the original tree structure.

import java.util.Scanner;
import java.util.Stack;

public class Problem297 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "N";
    /* StringBuilder result = new StringBuilder();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    stack.push(curr);
    while (!stack.isEmpty()) {
        curr = stack.pop();
        result.append(curr.val);
        result.append(",");
        if (curr.right != null)  {
            stack.push(curr.right);
        } else {
            result.append("#,");
        }
        if (curr.left != null) {
            stack.push(curr.left);
        } else {
            result.append("#,");
        }
    }
    System.out.println(result);
    return result.toString();*/
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return new TreeNode(0).right;
        Scanner scanner = new Scanner(data).useDelimiter(",");
        return helper(scanner);
    }

    private TreeNode helper(Scanner scanner) {
        String curr = scanner.next();
        if (curr.equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = helper(scanner);
        root.right = helper(scanner);
        return root;
    }
}
