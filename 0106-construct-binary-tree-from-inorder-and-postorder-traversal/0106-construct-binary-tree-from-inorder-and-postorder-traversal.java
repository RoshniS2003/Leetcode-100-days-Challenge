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
import java.util.HashMap;
import java.util.Map;

class Solution {
    private int postIdx;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;
        inorderMap = new HashMap<>();
        
        // Map values to their indices in the inorder array for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int left, int right) {
        // If there are no elements to construct the subtree
        if (left > right) {
            return null;
        }

        // The current root value from the postorder traversal
        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);

        // Split inorder traversal into left and right subtrees based on root index
        int index = inorderMap.get(rootVal);

        // Build right subtree first because postIdx moves backwards
        root.right = helper(inorder, postorder, index + 1, right);
        root.left = helper(inorder, postorder, left, index - 1);

        return root;
    }
}