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
    Integer ans = 0;
    public int longestZigZag(TreeNode root) {
        helper(root, true, 0);
        return ans;
    }
    
    public void helper(TreeNode root, boolean isLeftChild, int count){
        if (root != null) {
            ans = Math.max(ans, count);
            helper(root.right, false, isLeftChild ? count+1: 1);
            helper(root.left, true, isLeftChild ? 1 : count+1);
        }
    }
}