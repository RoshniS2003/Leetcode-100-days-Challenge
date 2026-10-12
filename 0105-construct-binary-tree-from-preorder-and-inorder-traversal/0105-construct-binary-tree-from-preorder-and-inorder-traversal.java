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

class Solution {
    private HashMap<Integer, Integer> inorderMap;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMap = new HashMap<>();
        
        // Store indices of inorder elements for O(1) lookups
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return arrayToTree(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // If there are no elements to construct the tree
        if (left > right) {
            return null;
        }
        
        // Get the current root value from preorder using preorderIndex and advance the index
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        // Find the index of this root in the inorder array
        int inorderIndex = inorderMap.get(rootValue);
        
        // Recursively build the left and right subtrees
        root.left = arrayToTree(preorder, left, inorderIndex - 1);
        root.right = arrayToTree(preorder, inorderIndex + 1, right);
        
        return root;
    }
}