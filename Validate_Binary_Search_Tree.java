public /**
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
    public boolean validateBST(TreeNode root, Integer lowerBound, Integer upperBound) {
        if (root == null) {
            return true;
        }

        if (lowerBound != null && root.val <= lowerBound || upperBound != null && root.val >= upperBound) {
            return false;
        }

        return validateBST(root.left, lowerBound, root.val) && validateBST(root.right, root.val, upperBound);

    }

    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }
}