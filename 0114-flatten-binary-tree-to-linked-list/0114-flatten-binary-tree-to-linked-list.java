/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(val) { this.val = val; }
 *     TreeNode(val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Keep track of the previously visited node during reverse post-order traversal
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Traverse right subtree first
        flatten(root.right);
        // Traverse left subtree next
        flatten(root.left);

        // Rewire pointers
        root.right = prev;
        root.left = null;
        prev = root;
    }
}