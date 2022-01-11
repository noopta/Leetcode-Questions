/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int breadthFirstSearch(TreeNode root, int maxDepth) {
        int returnSum = 0;
        int layerLen = 0;
        int i = 0;
        int currentDepth = 0;
        Queue<TreeNode> theQueue = new LinkedList<TreeNode>();

        if (root != null) {
            theQueue.add(root);
        }

        while (!theQueue.isEmpty()) {
            layerLen = theQueue.size();
            currentDepth++;

            for (i = 0; i < layerLen; i++) {
                TreeNode currentNode = theQueue.poll();

                if (currentDepth == maxDepth && currentNode.left == null && currentNode.right == null) {
                    returnSum += currentNode.val;
                }

                if (currentNode.left != null) {
                    theQueue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    theQueue.add(currentNode.right);
                }
            }
        }
        return returnSum;
    }

    public int findDepth(int currentDepth, TreeNode root) {
        Queue<TreeNode> theQueue = new LinkedList<TreeNode>();
        int i = 0;
        int layerLen = 0;
        int maxDepth = 0;

        if (root != null) {
            theQueue.add(root);
        }

        while (!theQueue.isEmpty()) {
            layerLen = theQueue.size();
            maxDepth++;

            for (i = 0; i < layerLen; i++) {
                TreeNode currentNode = theQueue.poll();

                if (currentNode.left != null) {
                    theQueue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    theQueue.add(currentNode.right);
                }
            }
        }
        return maxDepth;
    }

    public int deepestLeavesSum(TreeNode root) {
        int returnSum = 0;
        int maxDepth = 0;
        int i = 0;

        maxDepth = findDepth(0, root);

        return breadthFirstSearch(root, maxDepth);
    }
}