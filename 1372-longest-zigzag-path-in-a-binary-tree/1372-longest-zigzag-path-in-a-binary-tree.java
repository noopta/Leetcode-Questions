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
    int maxCount = 0;
    
    public int longestZigZag(TreeNode root) {
        depthFirstSearch(root, true, 0);    
        return maxCount;
    }
    
    public void depthFirstSearch(TreeNode root, boolean isLeftChild, int count){
        if(root != null){
            maxCount = Math.max(maxCount, count);
            depthFirstSearch(root.right, false, isLeftChild ? count + 1 : 1);
            depthFirstSearch(root.left, true, isLeftChild ? 1 : count + 1);
        }
    }
}