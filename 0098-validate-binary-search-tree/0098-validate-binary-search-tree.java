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
        if (root == null || root.left == null && root.right == null) return true;
        return checkIfBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean checkIfBST(TreeNode root, long min, long max) {
        if (root != null) {
            return root.val > min && root.val < max && checkIfBST(root.left, min, root.val) && checkIfBST(root.right, root.val, max);
        }
        return true;
    }
}
