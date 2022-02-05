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
    public void depthFirstSearch(TreeNode root, ArrayList<Integer> sumList, String currentString) {
        if (root.left == null && root.right == null) {
            sumList.add(Integer.parseInt(currentString));
            return;
        }

        if (root.left != null) {
            depthFirstSearch(root.left, sumList, currentString + Integer.toString(root.left.val));
        }

        if (root.right != null) {
            depthFirstSearch(root.right, sumList, currentString + Integer.toString(root.right.val));
        }
    }

    public int sumNumbers(TreeNode root) {
        int theSum = 0;
        ArrayList<Integer> sumList = new ArrayList<Integer>();
        String currentString = "";

        depthFirstSearch(root, sumList, currentString + Integer.toString(root.val));

        for (int currentNum : sumList) {
            theSum += currentNum;
        }

        return theSum;
    }
}