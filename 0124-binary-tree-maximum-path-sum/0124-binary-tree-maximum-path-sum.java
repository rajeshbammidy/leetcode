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
    int maxSum = 0;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxSum = root.val;
        findMaxPathSum(root);
        return maxSum;
    }

    int findMaxPathSum(TreeNode root) {
        if (root != null) {
            int left = Math.max(findMaxPathSum(root.left),0);
            int right = Math.max(findMaxPathSum(root.right),0);
            maxSum = Math.max(maxSum, left + right + root.val);
            return Math.max(left, right) + root.val;
        }
        return 0;
    }
}
