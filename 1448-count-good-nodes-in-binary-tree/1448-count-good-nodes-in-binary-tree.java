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
    public void depthFirstSearch(TreeNode root, int currentMax, ArrayList<Integer> nodeList){
        if(root == null){
            return;
        }
        
        if(root.val >= currentMax){
            nodeList.add(root.val);
            currentMax = root.val;
        } 
        
        depthFirstSearch(root.left, currentMax, nodeList);
        depthFirstSearch(root.right, currentMax, nodeList);
    }
    
    public int goodNodes(TreeNode root) {
        int numGoodNodes = 0;
        
        if(root == null){
            return 0;
        }
        
        int currentMax = root.val;
        ArrayList<Integer> nodeList = new ArrayList<Integer>();
        
        depthFirstSearch(root, currentMax, nodeList);
        
        return nodeList.size();
    }
}