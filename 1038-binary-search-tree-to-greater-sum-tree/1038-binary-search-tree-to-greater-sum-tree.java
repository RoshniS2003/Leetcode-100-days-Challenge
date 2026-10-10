/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        reverseInOrder(root);
        return root;
    }

    private void reverseInOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        // 1. Traverse the right subtree first (greater values)
        reverseInOrder(node.right);

        // 2. Update the current node's value with the cumulative sum
        sum += node.val;
        node.val = sum;

        // 3. Traverse the left subtree (smaller values)
        reverseInOrder(node.left);
    }
}