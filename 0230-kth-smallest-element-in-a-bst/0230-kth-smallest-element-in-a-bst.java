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
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Step 1: Reach the leftmost node of the current subtree
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Step 2: Process the node
            curr = stack.pop();
            k--;

            // Step 3: If k reaches 0, we found the kth smallest element
            if (k == 0) {
                return curr.val;
            }

            // Step 4: Visit the right subtree
            curr = curr.right;
        }

        return -1;
    }
}