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

    public boolean isBalanced(TreeNode root) {
        return checkIfBalanced(root) == -1 ? false : true;
    }

    int checkIfBalanced(TreeNode root) {
        if (root != null) {
            int left = checkIfBalanced(root.left);
            int right = checkIfBalanced(root.right);
            if (left == -1 || right == -1) return -1;
            if (Math.abs(left - right) > 1) return -1;
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
