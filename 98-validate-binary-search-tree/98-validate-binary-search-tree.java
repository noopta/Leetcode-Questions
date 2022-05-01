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
    public boolean isValidBST(TreeNode root) {
        return validateTree(root, null, null);
    }
    
    public boolean validateTree(TreeNode root, Integer lowerBound, Integer upperBound){
        if(root == null){
            return true;
        }
        
        if(lowerBound != null && root.val <= lowerBound || upperBound != null && root.val >= upperBound){
            return false;
        }
        
        return validateTree(root.left, lowerBound, root.val) && validateTree(root.right, root.val, upperBound);
    }
}