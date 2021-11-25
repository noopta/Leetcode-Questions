/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> returnList = new ArrayList<Integer>();
        Queue<TreeNode> theQueue = new LinkedList<TreeNode>();
        int i = 0;
        int levelLen = 0;

        if (root != null) {
            theQueue.add(root);
        }

        while (!theQueue.isEmpty()) {
            levelLen = theQueue.size();

            returnList.add(theQueue.peek().val);

            for (i = 0; i < levelLen; i++) {
                TreeNode tempNode = theQueue.poll();

                if (tempNode.right != null) {
                    theQueue.add(tempNode.right);
                }

                if (tempNode.left != null) {
                    theQueue.add(tempNode.left);
                }
            }
        }

        return returnList;
    }
}