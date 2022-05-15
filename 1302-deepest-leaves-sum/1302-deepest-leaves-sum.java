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
    public int findLeavesSum(TreeNode root, int lowestLevel){
        int leavesSum = 0;
        Queue<TreeNode> theQueue = new LinkedList<TreeNode>();
        int layerLen = 0;
        int currentLevel = 0;
        int i = 0;
        
        if(root != null){
            theQueue.add(root);
        }
        
        while(!theQueue.isEmpty()){
            layerLen = theQueue.size();
            
            for(i = 0; i < layerLen; i++){
                TreeNode currentNode = theQueue.poll();
                
                if(currentLevel == lowestLevel - 1){
                    leavesSum += currentNode.val;
                }
                
                if(currentNode.left != null){
                    theQueue.add(currentNode.left);
                }
                
                if(currentNode.right != null){
                    theQueue.add(currentNode.right);
                }
            }
            
            currentLevel++;
        }
        
        return leavesSum;
    }
    
    public int breadthFirstSearch(TreeNode root){
        Queue<TreeNode> theQueue = new LinkedList<TreeNode>();
        int layerLen = 0;
        int i = 0;
        int lowestLevel = 0;
        
        if(root != null){
            theQueue.add(root);
        }
        
        while(!theQueue.isEmpty()){
            layerLen = theQueue.size();
            
            for(i = 0; i < layerLen; i++){
                TreeNode currentNode = theQueue.poll();
                
                if(currentNode.left != null){
                    theQueue.add(currentNode.left);
                }
                
                if(currentNode.right != null){
                    theQueue.add(currentNode.right);
                }
            }
            
            lowestLevel++;    
        }
        
        return lowestLevel;
    }
    public int deepestLeavesSum(TreeNode root) {
        int lowestLevel = breadthFirstSearch(root);
        
        return findLeavesSum(root, lowestLevel);
    }
}